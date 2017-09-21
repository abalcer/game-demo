package com.brainacademy.game.skills;

import com.brainacademy.game.model.Player;

public class CurseSkill implements Skill {

    @Override
    public void apply(double skillPowerFactor, Player player) {
        player.resetSkillPowerFactor();
    }

    @Override
    public boolean isActiveSkill() {
        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
