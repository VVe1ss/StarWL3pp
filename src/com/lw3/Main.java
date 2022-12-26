package com.lw3;

import com.lw3.views.CommandHandler;
import com.lw3.views.MainMenu;

public class Main {
    public static void main(String[] args) {
        CommandHandler.run(new MainMenu());
    }
}
