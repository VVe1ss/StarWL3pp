package com.lw3.views.droids.cRuD.info.delete;

import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.droids.DroidsMenu;

public class DeleteDroid extends Command {
    private final JsonConverterData data;
    int i;
    public DeleteDroid(JsonConverterData data, int i) {
        this.data = data;
        this.i = i;
    }

    @Override
    protected Command execute() {
        data.getCreatedDroids().remove(i);
        JsonConverter.convertToJson(data);
        return new DroidsMenu();
    }
}
