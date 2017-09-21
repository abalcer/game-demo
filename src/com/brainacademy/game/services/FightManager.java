package com.brainacademy.game.services;

import com.brainacademy.game.model.*;
import com.brainacademy.game.skills.Skill;
import com.brainacademy.game.utils.RandomUtils;

public class FightManager {
    private final PlayerFactoryBuilder playerFactoryBuilder;
    private final CommandBuilder commandBuilder;

    private Command[] commands;
    private int assaultCommandIdx;

    public FightManager(PlayerFactoryBuilder playerFactoryBuilder, CommandBuilder commandBuilder) {
        this.playerFactoryBuilder = playerFactoryBuilder;
        this.commandBuilder = commandBuilder;
    }

    public void start() {
        commands = commandBuilder.buildCommandsArray(playerFactoryBuilder);
        assaultCommandIdx = RandomUtils.getRandomVal(2);
    }

    public boolean hasNextMove() {
        return commands[0].hasLive() && commands[1].hasLive();
    }

    public Move nextMove() {
        int nextCommandIdx = assaultCommandIdx == 0 ? 1 : 0;

        Player assault = RandomUtils.getRandomElement(commands[assaultCommandIdx].getLivePlayers());
        Skill skill = RandomUtils.getRandomElement(assault.getSkills());

        Player enemy;
        if (skill.isActiveSkill()) {
            enemy = RandomUtils.getRandomElement(commands[nextCommandIdx].getLivePlayers());
        } else {
            enemy = RandomUtils.getOtherRandomElement(commands[assaultCommandIdx].getLivePlayers(), assault);
        }

        skill.apply(assault.getSkillPowerFactor(), enemy);
        assault.resetSkillPowerFactor();

        assaultCommandIdx = nextCommandIdx;
        return new Move(assault, enemy, skill);
    }

    public Race getWinner() {
        return commands[0].hasLive() ? commands[0].getRace() : commands[1].getRace();
    }

    public Command[] getCommands() {
        return commands;
    }
}
