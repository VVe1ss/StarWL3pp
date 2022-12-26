package com.lw3.droids;

import com.lw3.attacks.A1.HealerA1;
import com.lw3.attacks.A2.HealerA2;
import com.lw3.attacks.A3.HealerA3;
import com.lw3.attacks.Attack;

import java.util.ArrayList;
import java.util.Arrays;

public class HealerDroid extends Droid{
    private static final HealerA1 healerA1 = new HealerA1();
    private static final HealerA2 healerA2 = new HealerA2();
    private static final HealerA3 healerA3 = new HealerA3();

    public HealerDroid(boolean newDroid) {
        super(newDroid);
    }

    public HealerDroid(Droid droid) {
        super(droid);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(healerA1, healerA2, healerA3));
    }
}
