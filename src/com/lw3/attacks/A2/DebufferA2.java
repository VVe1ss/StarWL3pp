package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class DebufferA2 extends Attack {
    public DebufferA2() {
        this.name = "Дебаф на захист";
        this.shortDesc = "Зменшує захист суперника на 50%";
        this.baseCoolDown = 3;
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            defenderTeam.droids().forEach(droid -> droid.setDefence((int) (droid.getDefence()*0.5)));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
