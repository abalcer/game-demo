package com.brainacademy.game.skills;

import com.brainacademy.game.model.Player;

public class DiseaseSkill extends AbstractPowerSkill {

    public DiseaseSkill(double skillPower) {
        super(skillPower);
    }

    @Override
    public void apply(double skillPowerFactor, Player player) {
        player.setSkillPowerFactor(skillPower);
    }
}
