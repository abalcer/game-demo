package com.brainacademy.game.services;

import com.brainacademy.game.model.*;
import com.brainacademy.game.skills.AttackSkill;
import com.brainacademy.game.skills.CurseSkill;
import com.brainacademy.game.skills.DiseaseSkill;
import com.brainacademy.game.skills.EnhancementSkill;

import java.util.HashMap;
import java.util.Map;

public class PlayerFactoryBuilder {
    private static Map<Race, PlayerFactory> playerFactoryMap = new HashMap<>();
    private static PlayerFactoryBuilder instance;

    static {
        playerFactoryMap.put(Race.ELVES, PlayerFactory.registerRace(Race.ELVES)
                .forType(new Magic("маг"))
                .withSkill(new EnhancementSkill(1.5))
                .withSkill(new AttackSkill(Weapon.MAGIC, 10.0))
                .and()
                .forType(new Archer("лучник"))
                .withSkill(new AttackSkill(Weapon.BOW, 7.0))
                .withSkill(new AttackSkill(Weapon.MELEE, 3.0))
                .and()
                .forType(new Warrior("воин"))
                .withSkill(new AttackSkill(Weapon.SWORD, 15.0))
                .and()
                .create());

        playerFactoryMap.put(Race.HUMAN, PlayerFactory.registerRace(Race.HUMAN)
                .forType(new Magic("маг"))
                .withSkill(new EnhancementSkill(1.5))
                .withSkill(new AttackSkill(Weapon.MAGIC, 4.0))
                .and()
                .forType(new Archer("арбалетчик"))
                .withSkill(new AttackSkill(Weapon.CROSSBOW, 5.0))
                .withSkill(new AttackSkill(Weapon.MELEE, 3.0))
                .and()
                .forType(new Warrior("воин"))
                .withSkill(new AttackSkill(Weapon.SWORD, 18.0))
                .and()
                .create());

        playerFactoryMap.put(Race.ORCS, PlayerFactory.registerRace(Race.ORCS)
                .forType(new Magic("шаман"))
                .withSkill(new EnhancementSkill(1.5))
                .withSkill(new CurseSkill())
                .and()
                .forType(new Archer("лучник"))
                .withSkill(new AttackSkill(Weapon.BOW, 3.0))
                .withSkill(new AttackSkill(Weapon.KNIFE, 2.0))
                .and()
                .forType(new Warrior("гоблин"))
                .withSkill(new AttackSkill(Weapon.CLUB, 20.0))
                .and()
                .create());

        playerFactoryMap.put(Race.UNDEAD, PlayerFactory.registerRace(Race.UNDEAD)
                .forType(new Magic("некромант"))
                .withSkill(new DiseaseSkill(0.5))
                .withSkill(new AttackSkill(Weapon.MAGIC, 5.0))
                .and()
                .forType(new Archer("охотник"))
                .withSkill(new AttackSkill(Weapon.BOW, 4.0))
                .withSkill(new AttackSkill(Weapon.MELEE, 2.0))
                .and()
                .forType(new Warrior("зомби"))
                .withSkill(new AttackSkill(Weapon.SPEAR, 18.0))
                .and()
                .create());
    }


    private PlayerFactoryBuilder() {
    }

    public static PlayerFactoryBuilder getInstance() {
        if (instance == null) {
            instance = new PlayerFactoryBuilder();
        }
        return instance;
    }
    
    public PlayerFactory build(Race race) {
        return playerFactoryMap.get(race);
    }
}
