package com.lw3.views.game.read.startOrDelete.start;

import com.lw3.game.Game;
import com.lw3.game.GameImpl;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.MainMenu;

public class StartRecordedGame extends Command {
    private int i;
    private JsonConverterData data;
    public StartRecordedGame(int i) {
        this.data = JsonConverter.convertToJsonConverterData();
        this.i = i;
    }

    @Override
    protected Command execute() {
        Game game = new GameImpl(data.getGames().get(i));
        game.run();
        int input;
        do {
            System.out.println("""
               Гру закінчено
               1-> Головне меню""");
            input = getSc().nextInt();
        } while (input !=1);
        return new MainMenu();
    }
}
