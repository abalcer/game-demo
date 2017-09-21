package com.brainacademy.game.skills;

import com.brainacademy.game.model.Player;

public class EnhancementSkill extends AbstractPowerSkill {
    public EnhancementSkill(double skillPower) {
        super(skillPower);
    }

    @Override
    public void apply(double skillPowerFactor, Player player) {
        player.setSkillPowerFactor(skillPower);
    }

    @Override
    public boolean isActiveSkill() {
        return false;
    }
}
