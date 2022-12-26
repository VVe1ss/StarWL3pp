package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class TankDroidA2 extends Attack {

    public TankDroidA2() {
        this.baseCoolDown = 3;
        this.name = "TankDroidA2";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

            enemy.setHp((int) (enemy.getHp() - self.getAtc()*4));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
