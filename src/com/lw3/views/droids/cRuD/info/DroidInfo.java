package com.lw3.views.droids.cRuD.info;

import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.droids.cRuD.DroidMenu;
import com.lw3.views.droids.cRuD.info.delete.DeleteDroid;

public class DroidInfo extends Command {
    private JsonConverterData data;
    private int i;
    public DroidInfo(JsonConverterData data, int i) {
        this.data = data;
        this.i = i;
    }

    @Override
    protected Command execute() {
        int input;
        do {
            System.out.println(data.getCreatedDroids().get(i).toString());
            System.out.println("1-> Видалити");
            System.out.println("2-> Назад");
            input = getSc().nextInt();
        } while (input<1 || input>2);
        if (input == 1)
            return new DeleteDroid(data, i);
        return new DroidMenu();
    }
}
