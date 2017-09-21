package com.brainacademy.game.model;

import com.brainacademy.game.skills.Skill;

public class Move {
    private final Player assault;
    private final Player enemy;
    private final Skill skill;

    public Move(Player assault, Player enemy, Skill skill) {
        this.assault = assault;
        this.enemy = enemy;
        this.skill = skill;
    }

    public Player getAssault() {
        return assault;
    }

    public Player getEnemy() {
        return enemy;
    }

    public Skill getSkill() {
        return skill;
    }

    @Override
    public String toString() {
        return "Move{" +
                "assault=" + assault +
                ", enemy=" + enemy +
                ", skill=" + skill +
                '}';
    }
}
