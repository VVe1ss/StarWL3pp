package com.lw3.views.droids.cRuD;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.droids.DroidsMenu;
import com.lw3.views.droids.cRuD.info.DroidInfo;

public class DroidMenu extends Command {
    private final JsonConverterData data;
    public DroidMenu() {
        this.data = JsonConverter.convertToJsonConverterData();
    }
    @Override
    protected Command execute() {
        int input;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < data.getCreatedDroids().size()){
            sb.append(i).append("-> ").append(data.getCreatedDroids().get(i).getName()).append("\n");
            i++;
        }
        sb.append("\n").append(i).append("-> Назад");
        do {
            System.out.println(sb);
            input = getSc().nextInt();
        } while (input<0 || input>i);
        if (input != i)
            return new DroidInfo(data, input);
        return new DroidsMenu();
    }
}
