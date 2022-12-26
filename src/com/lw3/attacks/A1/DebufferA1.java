package com.lw3.attacks.A1;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.Scanner;

public class DebufferA1 extends Attack {
    public DebufferA1() {
        this.name = "Захисний удар";
        this.shortDesc = "Завдає шкоди противнику, на 170% сили атаки";
    }

    @Override
    public boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc) {
        Droid defender = chooseDroid(defenderTeam, false,moves ,recorded,sc);
        defender.setHp((int) (defender.getHp()-self.getAtc()*1.7));
        return true;
    }
}
