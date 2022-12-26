package com.lw3.views.droids.create;

import com.lw3.droids.DebufferDroid;
import com.lw3.droids.HealerDroid;
import com.lw3.droids.AttackerDroid;
import com.lw3.droids.TankDroid;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.droids.DroidsMenu;

public class CreateDroidMenu extends Command {
    private final JsonConverterData data;
    public CreateDroidMenu() {
        this.data = JsonConverter.convertToJsonConverterData();
    }

    @Override
    public Command execute() {
        int input;
        do {
            // TODO: 19.12.2022 Додати тут
            System.out.println("""
                    Виберіть дроїда, якого типу ви хочере створити,
                    двічі напишіть номер для опису кожного типу
                    1--> Attacker
                    2--> Tank
                    3--> Healer
                    4--> Debuffer
                    """);
            input = getSc().nextInt();
            // TODO: 19.12.2022 додати тут
            if (input == 11)
                System.out.println(AttackerDroid.description);
            if (input == 22)
                System.out.println(TankDroid.description);
            if (input == 33)
                System.out.println(HealerDroid.description);
            if (input == 44)
                System.out.println(DebufferDroid.description);
        } while (input<0 || input>4);

        // TODO: 19.12.2022 Додати тут
        if (input == 1)
            data.getAttackerDroids().add(new AttackerDroid(true));
        if (input == 2)
            data.getTankDroids().add(new TankDroid(true));
        if (input == 3)
            data.getHealerDroids().add(new HealerDroid(true));
        if (input == 4)
            data.getDebufferDroids().add(new DebufferDroid(true));
        JsonConverter.convertToJson(data);
        return new DroidsMenu();
    }
}
