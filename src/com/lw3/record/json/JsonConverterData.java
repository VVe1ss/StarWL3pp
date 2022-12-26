package com.lw3.record.json;
import com.lw3.droids.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JsonConverterData {
    // TODO: 19.12.2022 добавити тут
    private List<GameDataDto> games = new ArrayList<>();
    private List<AttackerDroid> attackerDroids = new ArrayList<>();
    private List<TankDroid> tankDroids = new ArrayList<>();
    private List<HealerDroid> healerDroids = new ArrayList<>();
    private List<DebufferDroid> debufferDroids = new ArrayList<>();

    // TODO: 18.12.2022 додати новий тип
    public ArrayList<Droid> getCreatedDroids(){
        ArrayList<Droid> droids = new ArrayList<>(attackerDroids);
        droids.addAll(tankDroids);
        droids.addAll(healerDroids);
        droids.addAll(debufferDroids);
        return droids;
    }
//
//
//    public JsonConverterData(List<PreciousStone> stones, Necklace necklace, List<StoneType> types) {
//        this.necklace = Objects.requireNonNullElseGet(necklace, () -> new Necklace(new LinkedHashSet<>()));
//        this.stones = Objects.requireNonNullElseGet(stones, ArrayList::new);
//        this.types = Objects.requireNonNullElseGet(types, ArrayList::new);
//    }

}