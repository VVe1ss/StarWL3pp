package com.lw3.views.game.read.startOrDelete;

import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.game.read.ReadGame;
import com.lw3.views.game.read.startOrDelete.delete.DeleteRecordedGame;
import com.lw3.views.game.read.startOrDelete.start.StartRecordedGame;

public class GameDeleteOrStart extends Command {
    private int i;
    private JsonConverterData data;
    public GameDeleteOrStart(int input) {
        this.i = input;
        this.data = JsonConverter.convertToJsonConverterData();
    }

    @Override
    protected Command execute() {
        int input;
        do {
            System.out.printf("""
                    Вибрано гру %s
                    1-> Запустити
                    2-> Видалити запис
                    3-> Назад""", data.getGames().get(i).getTime());
            input = getSc().nextInt();
        } while (input<1 || input>3);
        if (input == 1)
            return new StartRecordedGame(i);
        if (input == 2)
            return new DeleteRecordedGame(i);
        return new ReadGame();
    }
}
