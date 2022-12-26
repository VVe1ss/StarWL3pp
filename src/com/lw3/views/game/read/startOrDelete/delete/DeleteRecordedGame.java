package com.lw3.views.game.read.startOrDelete.delete;

import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.game.GameMenu;

public class DeleteRecordedGame extends Command {
    private int i;
    private JsonConverterData data;
    public DeleteRecordedGame(int i) {
        this.i = i;
        this.data = JsonConverter.convertToJsonConverterData();
    }

    @Override
    protected Command execute() {
        data.getGames().remove(i);
        JsonConverter.convertToJson(data);
        return new GameMenu();
    }
}
