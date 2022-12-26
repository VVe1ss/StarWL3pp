package com.lw3.game.team;

import com.lw3.droids.*;
import lombok.Setter;
import java.util.ArrayList;

@Setter
public class Team {
    // TODO: 19.12.2022 Добавити тут
    private String name;
    private ArrayList<AttackerDroid> attackerDroids = new ArrayList<>();
    private ArrayList<TankDroid> tankDroids = new ArrayList<>();
    private ArrayList<HealerDroid> healerDroids = new ArrayList<>();
    private ArrayList<DebufferDroid> debufferDroidDroids = new ArrayList<>();

    public Team () {}

    // TODO: 19.12.2022 добавити тут
    public Team (Team team) {
        this.name = team.name;
        this.tankDroids = new ArrayList<>();
        team.tankDroids.forEach(tankDroid -> tankDroids.add(new TankDroid(tankDroid)));
        this.attackerDroids = new ArrayList<>();
        team.attackerDroids.forEach(sneakyDroid -> attackerDroids.add(new AttackerDroid(sneakyDroid)));
        this.healerDroids = new ArrayList<>();
        team.healerDroids.forEach(healerDroid -> healerDroids.add(new HealerDroid(healerDroid)));
        this.debufferDroidDroids = new ArrayList<>();
        team.debufferDroidDroids.forEach(debufferDroid -> debufferDroidDroids.add(new DebufferDroid(debufferDroid)));

    }

    // TODO: 19.12.2022 Добавити тут
    public ArrayList<Droid> droids() {
        ArrayList<Droid> droids = new ArrayList<>(attackerDroids);
        droids.addAll(tankDroids);
        droids.addAll(healerDroids);
        droids.addAll(debufferDroidDroids);
        return droids;
    }

    // TODO: 19.12.2022 Додати тут
    public void addDroid (Droid droid){
        if (droid instanceof AttackerDroid)
            attackerDroids.add((AttackerDroid) droid);
        else if (droid instanceof TankDroid)
            tankDroids.add((TankDroid) droid);
        else if (droid instanceof HealerDroid)
            healerDroids.add((HealerDroid) droid);
        else if (droid instanceof DebufferDroid)
            debufferDroidDroids.add((DebufferDroid) droid);
    }

    public String name() {
        return name;
    }
}
