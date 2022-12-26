package com.lw3.views.droids;

import com.lw3.views.Command;
import com.lw3.views.MainMenu;
import com.lw3.views.droids.cRuD.DroidMenu;
import com.lw3.views.droids.create.CreateDroidMenu;

public class DroidsMenu extends Command {
    @Override
    protected Command execute() {
        int input;
        do {
            System.out.println("""
                1-> Переглянути список або модифікувати створених дроїдів
                2-> Створити нового дроїда
                3-> Назад
                """);
            input = getSc().nextInt();
        } while (input<1 || input>3);
        if (input == 1)
            return new DroidMenu();
        if (input == 2)
            return new CreateDroidMenu();
        return new MainMenu();
    }
}
