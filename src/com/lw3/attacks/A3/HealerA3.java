package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class HealerA3 extends Attack {
    public HealerA3() {
        this.baseCoolDown = 4;
        this.name = "Прийняти міри";
        this.shortDesc = "Заберає в противників 10% здоров'я та передає їх союзникам";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            int value = (int) (self.getHp()*0.1);
            attackTeam.droids().forEach(droid -> droid.setHp(droid.getHp()+value));
            defenderTeam.droids().forEach(droid -> droid.setHp(droid.getHp()-value));
            return true;
        }
        return false;
    }
}
