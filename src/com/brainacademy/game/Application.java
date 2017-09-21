package com.brainacademy.game;

import com.brainacademy.game.config.PlayerConfiguration;
import com.brainacademy.game.model.CharacterClassType;
import com.brainacademy.game.model.Command;
import com.brainacademy.game.model.CommandBuilder;
import com.brainacademy.game.model.Move;
import com.brainacademy.game.services.FightManager;

public class Application {

    public static void main(String[] args) {
        PlayerConfiguration playerConfiguration = new PlayerConfiguration();
        playerConfiguration.configure();

        CommandBuilder commandBuilder = new CommandBuilder()
                .withCharacterClass(CharacterClassType.MAGIC, 1)
                .withCharacterClass(CharacterClassType.ARCHER, 3)
                .withCharacterClass(CharacterClassType.WARRIOR, 4);

        FightManager fightManager = new FightManager(playerConfiguration, commandBuilder);

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
