package com.lw3.droids;

import com.lw3.attacks.A1.AttackerA1;
import com.lw3.attacks.A2.AttackerA2;
import com.lw3.attacks.A3.AttackerA3;
import com.lw3.attacks.Attack;
import java.util.ArrayList;
import java.util.Arrays;

public class AttackerDroid extends Droid{
    private static final AttackerA1 ATTACKER_A_1 = new AttackerA1();
    private static final AttackerA2 ATTACKER_A_2 = new AttackerA2();
    private static final AttackerA3 ATTACKER_A_3 = new AttackerA3();

    public AttackerDroid(boolean newDroid) {
        super(newDroid);
    }

    public AttackerDroid(Droid droid) {
        super(droid);
        AttackerDroid attackerDroid = (AttackerDroid) droid;
    }

    public AttackerDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(ATTACKER_A_1, ATTACKER_A_2, ATTACKER_A_3));
    }
}
