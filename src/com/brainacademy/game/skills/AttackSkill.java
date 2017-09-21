package com.brainacademy.game.skills;

import com.brainacademy.game.model.Player;
import com.brainacademy.game.model.Weapon;

public class AttackSkill extends AbstractPowerSkill {
    private final Weapon weapon;

    public AttackSkill(Weapon weapon, double skillPower) {
        super(skillPower);
        this.weapon = weapon;
    }

    @Override
    public void apply(double skillPowerFactor, Player player) {
        player.applyDamage(skillPower * skillPowerFactor);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return "AttackSkill{" +
                "weapon=" + weapon +
                '}';
    }
}
