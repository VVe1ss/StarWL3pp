package com.lw3.attacks.A3;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class TankDroidA3 extends Attack {
    public TankDroidA3() {
        this.baseCoolDown = 4;
        this.name = "Силова атака захисним полем";
        this.shortDesc = "Наносить удар одному ворогу на 350% своєї атаки";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

            enemy.setHp((int) (enemy.getHp() - self.getAtc()*3.5));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
