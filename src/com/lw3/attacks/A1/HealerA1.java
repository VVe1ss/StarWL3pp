package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class HealerA1 extends Attack {
    public HealerA1() {
        this.name = "Кинути отруту";
        this.shortDesc = "Атакує одного противника на 80% від своєї атаки";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        Droid enemy = chooseDroid(defenderTeam,false,moves,recorded,sc);
        enemy.setHp((int) (enemy.getHp()-self.getAtc()*0.8));
        return true;
    }
}
