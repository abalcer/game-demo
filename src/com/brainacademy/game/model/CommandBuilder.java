package com.brainacademy.game.model;

import com.brainacademy.game.config.PlayerConfiguration;
import com.brainacademy.game.services.PlayerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandBuilder {
    private Map<CharacterClassType, Integer> commandMap = new HashMap<>();

    public CommandBuilder withCharacterClass(CharacterClassType type, int count) {
        commandMap.put(type, count);
        return this;
    }

    public Command build(Race race, PlayerConfiguration playerConfiguration) {
        PlayerFactory playerFactory = playerConfiguration.getPlayerFactoryForRace(race);
        Command command = new Command(race);
        for (Map.Entry<CharacterClassType, Integer> entry : commandMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                command.addPlayer(playerFactory.createPlayer(entry.getKey()));
            }
        }
        return command;
    }
}
