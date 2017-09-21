package com.brainacademy.game.services;

import com.brainacademy.game.model.CharacterClass;
import com.brainacademy.game.model.CharacterClassType;
import com.brainacademy.game.model.Race;
import com.brainacademy.game.skills.Skill;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactoryRegistry {
    private final Race race;
    private List<CharacterClass> types = new ArrayList<>();

    PlayerFactoryRegistry(Race race) {
        this.race = race;
    }

    public SkillFactoryRegistry forType(CharacterClass type) {
        types.add(type);
        return new SkillFactoryRegistry(type);
    }

    public PlayerFactory create() {
        return new PlayerFactory(this);
    }

    Race getRace() {
        return race;
    }

    CharacterClass getType(CharacterClassType type) {
        for (CharacterClass characterClass : types) {
            if (characterClass.getType().equals(type)) {
                return characterClass;
            }
        }

        return null;
    }

    public class SkillFactoryRegistry {
        private final CharacterClass type;

        private SkillFactoryRegistry(CharacterClass type) {
            this.type = type;
        }

        public SkillFactoryRegistry withSkill(Skill skill) {
            SkillFactory.registerSkill(skill, race, type);
            return this;
        }

        public PlayerFactoryRegistry and() {
            return PlayerFactoryRegistry.this;
        }
    }
}
