package com.brainacademy.game.model;

import com.brainacademy.game.skills.Skill;

import java.util.List;

public class Player {
    private static final int DEFAULT_SKILL_POWER_FACTOR = 1;

    private final Race race;
    private final CharacterClass characterClass;

    private List<Skill> skills;
    private double skillPowerFactor = DEFAULT_SKILL_POWER_FACTOR;

    private double hitpoint;

    public Player(Race race, CharacterClass characterClass) {
        this.race = race;
        this.characterClass = characterClass;
    }

    public Race getRace() {
        return race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void applyDamage(double skillPower) {
        hitpoint = Math.max(0, hitpoint - skillPower);
    }

    public double getSkillPowerFactor() {
        return skillPowerFactor;
    }

    public void setSkillPowerFactor(double skillPowerFactor) {
        this.skillPowerFactor = skillPowerFactor;
    }

    public void resetSkillPowerFactor() {
        this.skillPowerFactor = DEFAULT_SKILL_POWER_FACTOR;
    }

    public double getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(double hitpoint) {
        this.hitpoint = hitpoint;
    }

    public String getName() {
        return characterClass.getName();
    }

    @Override
    public String toString() {
        return "Player{" +
                "race=" + race +
                ", name=" + characterClass.getName() +
                ", hitpoint=" + hitpoint +
                '}';
    }

    public boolean isLive() {
        return hitpoint > 0;
    }
}
