package com.brainacademy.game.model;

import java.util.ArrayList;
import java.util.List;

public class Command {
    private final Race race;

    private List<Player> players = new ArrayList<>();

    public Command(Race race) {
        this.race = race;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean hasLive() {
        int totalHitpoints = 0;
        for (Player player : players) {
            totalHitpoints += player.getHitpoint();
        }
        return totalHitpoints > 0;
    }

    public List<Player> getLivePlayers() {
        List<Player> livePlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.isLive()) {
                livePlayers.add(player);
            }
        }
        return livePlayers;
    }

    public Race getRace() {
        return race;
    }
}
