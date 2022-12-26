package com.lw3.attacks.A2;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.AttackerDroid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class AttackerA2 extends Attack {
    public AttackerA2() {
        this.baseCoolDown = 2;
        this.name = "Посилена атака";
        this.shortDesc = "Атакує 1 противника на 200% від своєї атаки";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        if (coolDown == 0){
            Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

            AttackerDroid attackerDroid = (AttackerDroid) self;
            enemy.setHp((int) (enemy.getHp() - (self.getAtc()*2)));
            coolDown = baseCoolDown;
            return true;
        }
        return false;
    }
}
