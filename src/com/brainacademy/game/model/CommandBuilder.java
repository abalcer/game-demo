package com.brainacademy.game.model;

import com.brainacademy.game.services.PlayerFactoryBuilder;
import com.brainacademy.game.services.PlayerFactory;
import com.brainacademy.game.utils.RandomUtils;

import java.util.*;

public class CommandBuilder {
    private Map<CharacterClassType, Integer> commandMap = new HashMap<>();
    private List<Race[]> allianceRaces = new ArrayList<>();

    public CommandBuilder withCharacterClass(CharacterClassType type, int count) {
        commandMap.put(type, count);
        return this;
    }

    public CommandBuilder withAllianceRaces(Race... races) {
        allianceRaces.add(races);
        return this;
    }

    public Command[] buildCommandsArray(PlayerFactoryBuilder playerFactoryBuilder) {
        Race race1 = RandomUtils.getRandomElement(allianceRaces.get(0));
        Race race2 = RandomUtils.getRandomElement(allianceRaces.get(1));
        return new Command[]{
                build(race1, playerFactoryBuilder),
                build(race2, playerFactoryBuilder)
        };
    }

    public Command build(Race race, PlayerFactoryBuilder playerFactoryBuilder) {
        PlayerFactory playerFactory = playerFactoryBuilder.build(race);
        Command command = new Command(race);
        for (Map.Entry<CharacterClassType, Integer> entry : commandMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                command.addPlayer(playerFactory.createPlayer(entry.getKey()));
            }
        }
        return command;
    }
}
