package com.lw3.droids;

import com.lw3.attacks.A1.TankDroidA1;
import com.lw3.attacks.A2.TankDroidA2;
import com.lw3.attacks.A3.TankDroidA3;
import com.lw3.attacks.Attack;

import java.util.ArrayList;
import java.util.Arrays;

public class TankDroid extends Droid {
    private static final TankDroidA1 tankDroidA1 = new TankDroidA1();
    private static final TankDroidA2 tankDroidA2 = new TankDroidA2();
    private static final TankDroidA3 tankDroidA3 = new TankDroidA3();

    public static String description = "Броньований дроїд, кожна його атака додатково завдає шкоди на 50% від захисту, захист в обороні на 50% ефективніший";

    public TankDroid(boolean newDroid) {
        super(newDroid);

    }

    public TankDroid(Droid droid) {
        super(droid);
    }

    public TankDroid(String name, int hp, int atc, int def) {
        super(name, hp, atc, def);
    }

    @Override
    public ArrayList<Attack> getAttacks() {
        return new ArrayList<>(Arrays.asList(tankDroidA1, tankDroidA2, tankDroidA3));
    }
}

