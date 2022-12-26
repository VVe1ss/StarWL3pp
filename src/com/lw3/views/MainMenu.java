package com.lw3.views;

import com.lw3.views.droids.DroidsMenu;
import com.lw3.views.game.GameMenu;

import java.util.Scanner;

public class MainMenu extends Command{
    @Override
    public Command execute() {

        int input;
        do {
            System.out.println("""
                Виберіть пункт меню за номером:
                1-> Список дроїдів
                2-> Розпочати гру
                """);
            System.setIn(System.in);
            input = getSc().nextInt();
        } while (input<1 || input>2);

        if (input == 1)
            return new DroidsMenu();
        return new GameMenu();
    }
}
