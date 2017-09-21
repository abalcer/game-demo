package com.brainacademy.game.skills;

abstract class AbstractPowerSkill implements Skill {
    final double skillPower;

    AbstractPowerSkill(double skillPower) {
        this.skillPower = skillPower;
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
