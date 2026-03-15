package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds=0;
        while(hero.isAlive() && boss.isAlive() && rounds<10){
            rounds++;
            int heroDamage=action.getDamage()+random.nextInt(6);
            boss.takeDamage(heroDamage);

            result.addLine(hero.getName()+" uses "+action.getActionName()+" dealing "+heroDamage+" damage");

            if (!boss.isAlive()){
                break;
            }
            int bossDamage=boss.getAttackPower()+random.nextInt(6);
            hero.takeDamage(bossDamage);
            result.addLine(boss.getName()+" hits back for "+bossDamage);
        }

        if(hero.isAlive()){
            result.setWinner(hero.getName());
        } 
        else{
            result.setWinner(boss.getName());
        }
        return result;
    }
}
