package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.droids.AttackerDroid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class AttackerA1 extends Attack {
    public AttackerA1() {
        this.name = "Пряма атака";
        this.shortDesc = "Атакує 1 противника на 100% від своєї атаки"; // gfgfgfg
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        AttackerDroid attackerDroid = (AttackerDroid) self;
        Droid enemy = chooseDroid(defenderTeam, false, moves, recorded, sc);

        enemy.setHp((int) (enemy.getHp() - (self.getAtc())));
        return true;
    }


}
