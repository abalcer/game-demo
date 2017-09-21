package com.brainacademy.game.model;

public abstract class CharacterClass {
    private final String name;
    private final CharacterClassType type;

    CharacterClass(String name, CharacterClassType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public CharacterClassType getType() {
        return type;
    }
}
