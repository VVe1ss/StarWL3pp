package com.lw3.views.game;

import com.lw3.views.Command;
import com.lw3.views.game.newGame.NewGame;
import com.lw3.views.game.read.ReadGame;

public class GameMenu extends Command {
    @Override
    protected Command execute() {
        int input;
        do {
            System.out.println("""
                    1-> Розпочати нову битву
                    2-> Відобразити результат завершеної гри зі списку
                    """);
            input = getSc().nextInt();
        } while (input<1 || input>2);
        if (input == 1)
            return new NewGame();
        return new ReadGame();
    }
}
