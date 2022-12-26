package com.lw3.game;

import com.lw3.droids.Droid;
import com.lw3.game.team.Team;

import java.util.List;
import java.util.Scanner;

public interface ChooseDroid {
    default Droid chooseDroid(Team team, boolean attacker, StringBuilder moves, boolean recorded, Scanner sc) {
//        Scanner sc = new Scanner(System.in);
        if (team.droids().size() == 1)
            return team.droids().get(0);
        else{

            int input;

            List<Droid> liveDroids = team.droids().stream().filter(droid -> droid.getHp()>0).toList();

            do {
                if (attacker)
                    System.out.println("Виберіть дроїда для атаки");
                else
                    System.out.println("Виберіть дроїда на якого застосувати атаку");

                for (int i = 0; i < team.droids().size(); i++) {
                    if (liveDroids.contains(team.droids().get(i)))
                        System.out.printf("%d -> %s\n",i+1, team.droids().get(i).getName());
                    else
                        System.out.printf("dead -> %s\n", team.droids().get(i).getName());
                }
                input = sc.nextInt();
                if (recorded)
                    System.out.println(input);
                moves.append(input).append(" ");
            } while (input<1 || input>team.droids().size());
            if (!liveDroids.contains(team.droids().get(input-1))){
                System.out.println("Не можна обрати мертвого дроїда");
                chooseDroid(team, attacker, moves, recorded, sc);
            }
            return team.droids().get(input-1);
        }
    }
}
