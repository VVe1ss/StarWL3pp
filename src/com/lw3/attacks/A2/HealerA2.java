package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class HealerA2 extends Attack {
    public HealerA2() {
        this.baseCoolDown = 3;
        this.name = "Екстрене лікування";
        this.shortDesc = "Лікує союзника на 20% свого здоров'я";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid friend = chooseDroid(attackTeam, true, moves, recorded, sc);
            friend.setHp((int) (friend.getHp()+self.getHp()*0.2));
            return true;
        }
        return false;
    }
}
