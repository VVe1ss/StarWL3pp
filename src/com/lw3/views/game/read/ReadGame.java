package com.lw3.views.game.read;

import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.game.GameMenu;
import com.lw3.views.game.read.startOrDelete.GameDeleteOrStart;

public class ReadGame extends Command {
    private JsonConverterData data;

    public ReadGame() {
        this.data = JsonConverter.convertToJsonConverterData();
    }

    @Override
    protected Command execute() {
        int input;
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < data.getGames().size()) {
            stringBuilder.append(i).append("-> ")
                    .append(data.getGames().get(i).getTime())
                    .append(String.format(" %s vs %s\n",
                            data.getGames().get(i).getTeam1().name(),
                            data.getGames().get(i).getTeam2().name()));
            i++;
        }
        stringBuilder.append(i).append("-> Назад");
        do {
            System.out.println(stringBuilder);
            input = getSc().nextInt();
        } while (input<0 || input>i);
        if (input != i)
            return new GameDeleteOrStart(input);
        return new GameMenu();
    }
}
