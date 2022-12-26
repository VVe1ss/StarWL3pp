package com.lw3.droids;

import com.lw3.attacks.Attack;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Scanner;
/**If I understood it right Gson uses reflection and empty constructor.
 * I cant find solution for use Gson with abstract classes,
 * so each Droid must have fields with his attacks and method which return list of these attacks*/
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public abstract class Droid {
    private int hp = 100;
    private int atc = 10;
    private int defence = 10;
    private String name;
    private int statsPoints;
    public static String description;

    public Droid(Droid droid) {
        this.name = droid.name;
        this.atc = droid.atc;
        this.defence = droid.defence;
        this.hp = droid.hp;
        this.statsPoints = droid.statsPoints;
    }

    public Droid(boolean newDroid) {
        if (newDroid)
            statsDistribution();
    }

    public Droid(String name, int hp, int atc, int def) {
        this.name = name;
        this.hp = hp;
        this.atc = atc;
        this.defence = def;
    }

    private void statsDistribution (){

        statsPoints = 10;
        Scanner s = new Scanner(System.in);
        String stats;

        System.out.println("Введіть назву робота");
        name = s.nextLine();

        while (statsPoints>0){
            System.out.printf("""
                    У вас залишилося %d очків, щоб розподілити їх між здоров'ям(h), атакою(a), та захистом робота(d),
                    впишіть дані показники відповідними символами зразу або по черзі.\s
                    щоб скинути очки введіть r
                    """, statsPoints);
            stats = s.nextLine();
            stats.chars().forEach(x-> {
                if (statsPoints>0)
                    switch (x) {
                        case 'h' -> {
                            hp += 100;
                            statsPoints--;
                        }
                        case 'a' -> {
                            atc += 10;
                            statsPoints--;
                        }
                        case 'd' -> {
                            defence += 10;
                            statsPoints--;
                        }
                        case 'r' -> {
                            hp = 100;
                            atc = 10;
                            defence = 10;
                            statsPoints = 10;
                        }
                    }
            });
        }
    }

    public abstract ArrayList<Attack> getAttacks();

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "hp=" + hp +
                ", atc=" + atc +
                ", defence=" + defence +
                ", name='" + name + '\'' +
                ", statsPoints=" + statsPoints +
                '}';
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
