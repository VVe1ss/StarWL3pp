package com.lw3.attacks;

import com.lw3.droids.Droid;
import com.lw3.game.ChooseDroid;
import com.lw3.game.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Attack implements ChooseDroid {
    protected String name = "no name";
    protected String shortDesc = "no description";
    protected int coolDown = 0;
    protected int baseCoolDown;

//    public abstract boolean attack(Droid self, Droid enemy);

    public abstract boolean prepareAndAttack(Droid self, Team attackTeam, Team defenderTeam, StringBuilder moves, boolean recorded, Scanner sc);

    public int getCoolDown(){
        return coolDown;
    }

    public String getName() {
        return name;
    }

    public void reduceCoolDown(){
        if (coolDown>0)
            this.coolDown--;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}

