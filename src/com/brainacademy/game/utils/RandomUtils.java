package com.brainacademy.game.utils;

import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static Random random = new Random(System.currentTimeMillis());

    public static <T> T getRandomElement(List<T> elements) {
        int idx = random.nextInt(elements.size());
        return elements.get(idx);
    }

    public static <T> T getRandomElement(T[] elements) {
        int idx = random.nextInt(elements.length);
        return elements[idx];
    }

    public static int getRandomVal(int bound) {
        return random.nextInt(bound);
    }

    public static <T> T getOtherRandomElement(List<T> elements, T except) {
        T res;
        while ((res = getRandomElement(elements)).equals(except)) ;
        return res;
    }
}
