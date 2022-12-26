package com.lw3.views;

public class CommandHandler {
    public static void run(Command command){
        while (command != null)
            command = command.execute();
    }
}
