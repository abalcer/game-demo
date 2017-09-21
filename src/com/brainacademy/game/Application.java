package com.brainacademy.game;

import com.brainacademy.game.services.PlayerFactoryBuilder;
import com.brainacademy.game.model.*;
import com.brainacademy.game.services.FightManager;

public class Application {

    public static void main(String[] args) {
        PlayerFactoryBuilder playerFactoryBuilder = PlayerFactoryBuilder.getInstance();

        CommandBuilder commandBuilder = new CommandBuilder()
                .withCharacterClass(CharacterClassType.MAGIC, 1)
                .withCharacterClass(CharacterClassType.ARCHER, 3)
                .withCharacterClass(CharacterClassType.WARRIOR, 4)
                .withAllianceRaces(Race.ELVES, Race.HUMAN)
                .withAllianceRaces(Race.ORCS, Race.UNDEAD);

        FightManager fightManager = new FightManager(playerFactoryBuilder, commandBuilder);

        fightManager.start();

        Command[] commands = fightManager.getCommands();
        System.out.println("Start fight: " +  commands[0].getRace() + " vs " + commands[1].getRace());
        System.out.println("-----------------------------------------");

        int moveNumber = 0;
        while (fightManager.hasNextMove()) {
            Move move = fightManager.nextMove();
            System.out.println(move);

            moveNumber++;
        }

        System.out.println("-----------------------------------------");

        System.out.println("Total moves: " + moveNumber);
        System.out.println("Win race: " + fightManager.getWinner());

    }
}
