package com.brainacademy.game.services;

import com.brainacademy.game.model.*;
import com.brainacademy.game.model.Player;

public class PlayerFactory {
    private static final int MAX_HITPOINT = 100;

    private final PlayerFactoryRegistry playerFactoryRegistry;

    PlayerFactory(PlayerFactoryRegistry playerFactoryRegistry) {
        this.playerFactoryRegistry = playerFactoryRegistry;
    }

    public Player createPlayer(CharacterClassType type) {
        Race race = playerFactoryRegistry.getRace();
        CharacterClass characterClass = playerFactoryRegistry.getType(type);
        Player player = new Player(race, characterClass);

        SkillFactory skillFactory = new SkillFactory(race);
        player.setSkills(skillFactory.createSkills(type));

        player.setHitpoint(MAX_HITPOINT);
        player.resetSkillPowerFactor();
        return player;
    }

    public static PlayerFactoryRegistry registerRace(Race race) {
        return new PlayerFactoryRegistry(race);
    }
}
