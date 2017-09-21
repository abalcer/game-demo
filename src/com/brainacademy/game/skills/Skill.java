package com.brainacademy.game.skills;

import com.brainacademy.game.model.Player;

public interface Skill {

    void apply(double skillPowerFactor, Player player);

    boolean isActiveSkill();
}
