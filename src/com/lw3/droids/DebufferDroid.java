package com.lw3.droids;

import com.lw3.attacks.A1.DebufferA1;
import com.lw3.attacks.A2.DebufferA2;
import com.lw3.attacks.A3.DebufferA3;
import com.lw3.attacks.Attack;

import java.util.ArrayList;
import java.util.Arrays;

public class DebufferDroid extends Droid{

    private static final DebufferA1 debufferA1 = new DebufferA1();
    private static final DebufferA2 debufferA2 = new DebufferA2();
    private static final DebufferA3 debufferA3 = new DebufferA3();


    public DebufferDroid(Droid droid) {
        super(droid);
    }

    public DebufferDroid(boolean newDroid) {
        super(newDroid);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(debufferA1,debufferA2,debufferA3));
    }
}
