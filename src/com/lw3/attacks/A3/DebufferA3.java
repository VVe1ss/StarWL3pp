package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class DebufferA3 extends Attack {
    public DebufferA3() {
        this.name = "Дебаф атаки";
        this.shortDesc = "Зменшує атаку суперника на 30%";
        this.baseCoolDown = 3;
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            defenderTeam.droids().forEach(droid -> droid.setAtc((int) (droid.getAtc()*0.7)));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
