package com.brainacademy.game.services;

import com.brainacademy.game.model.CharacterClass;
import com.brainacademy.game.model.CharacterClassType;
import com.brainacademy.game.model.Race;
import com.brainacademy.game.skills.Skill;

import java.util.*;

class SkillFactory {
    private static Map<PlayerTypeRaceKey, List<Skill>> skillMap = new HashMap<>();
    private final Race race;

    SkillFactory(Race race) {
        this.race = race;
    }

    List<Skill> createSkills(CharacterClassType type) {
        for (PlayerTypeRaceKey key : skillMap.keySet()) {
            if (key.race.equals(race) && key.characterClass.getType().equals(type)) {
                return skillMap.get(key);
            }
        }

        return null;
    }

    static void registerSkill(Skill skill, Race race, CharacterClass characterClass) {
        PlayerTypeRaceKey playerTypeRaceKey = new PlayerTypeRaceKey(race, characterClass);
        List<Skill> skills = skillMap.get(playerTypeRaceKey);
        if (skills == null) {
            skills = new ArrayList<>();
            skillMap.put(playerTypeRaceKey, skills);
        }
        skills.add(skill);
    }

    private static class PlayerTypeRaceKey {
        private Race race;
        private CharacterClass characterClass;

        PlayerTypeRaceKey(Race race, CharacterClass characterClass) {
            this.race = race;
            this.characterClass = characterClass;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlayerTypeRaceKey)) {
                return false;
            }

            PlayerTypeRaceKey that = (PlayerTypeRaceKey) obj;
            return race == that.race &&
                    characterClass == that.characterClass;
        }

        @Override
        public int hashCode() {
            return Objects.hash(race, characterClass);
        }
    }
}
