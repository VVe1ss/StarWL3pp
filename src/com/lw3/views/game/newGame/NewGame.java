package com.lw3.views.game.newGame;

import com.lw3.Main;
import com.lw3.droids.Droid;
import com.lw3.game.GameImpl;
import com.lw3.game.team.Team;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import com.lw3.views.Command;
import com.lw3.views.MainMenu;
import com.lw3.views.droids.create.CreateDroidMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NewGame extends Command {
    private Team team1;
    private Team team2;
    private JsonConverterData data;
    private ArrayList<Droid> unPicketDroids;

    public NewGame() {
        this.data = JsonConverter.convertToJsonConverterData();
        this.team1 = new Team();
        this.team2 = new Team();
        this.unPicketDroids = new ArrayList<>(data.getCreatedDroids());
    }

    @Override
    protected Command execute() {
        int input;
        checkIfThereIsAtLeast2DroidsForGame();
        createTeams();
        pickUpDroids();
        do {
            System.out.println("""
                Гру налаштовано, почати?
                1-> так
                2-> скинути""");
            input = getSc().nextInt();
        } while (input<1 || input>2);
        if (input == 1)
            new GameImpl(team1,team2).run();
        if (input == 2){
            do {
                System.out.println("""
                Точно?
                1-> так
                2-> ні, починаємо""");
                input = getSc().nextInt();
            } while (input<1 || input>2);
            if (input == 1)
                this.execute();
            else
                new GameImpl(team1,team2).run();
        }
        do {
            System.out.println("""
                Гру закінчено
                1-> повернутися до головно меню
                """);
            input = getSc().nextInt();
        } while (input!=1);
        return new MainMenu();
    }

    private void checkIfThereIsAtLeast2DroidsForGame(){
        int input;
        if (getUnPicketDroids().size() < 2){
            do {
                System.out.println("""
            Нажль не створено пари дроїдів, гру почати неможливо,
            додайте дроїда та спробуйте ще
            1-> До головного меню
            2-> До меню створення дроїда
            """);
                input = getSc().nextInt();
            } while (input<1 || input>2);
            if (input == 1)
                new MainMenu().execute();
            new CreateDroidMenu().execute();

        }
    }

    private void createTeams(){
        System.out.println("Введіть ім'я першої команди");
        team1.setName(getSc().nextLine());
        System.out.println("Введіть ім'я другої команди");
        team2.setName(getSc().nextLine());
    }

    private void pickUpDroids (){
        if (new Random().nextBoolean()){
            var buffer = team1;
            team1 = team2;
            team2 = buffer;
        }

        while (getUnPicketDroids().size() >= 2){
            System.out.println();
            if (pickUpDroid(team1)==-1)
                break;
            pickUpDroid(team2);
        }
    }

    private List<Droid> getUnPicketDroids(){
       return unPicketDroids;

    }

    private int pickUpDroid (Team team){
        int i = 0;
        int input;
        List<Droid> unPickedDroids = getUnPicketDroids();
        do {
            System.out.printf("\n%s команда обирає дроїда\n",team.name());
            while (i < unPickedDroids.size()) {
                System.out.printf("%d-> %s %s\t%n",
                        i,
                        unPickedDroids.get(i).getName(),
                        unPickedDroids.get(i).getClass().getSimpleName());
                i++;
            }
            if (team1.droids().size() == team2.droids().size() && team1.droids().size()>0)
                System.out.printf("%d-> Закінчити",i);
            input = getSc().nextInt();
        } while (input<0 || input>i);
        if (input!=i){
            team.addDroid(unPickedDroids.get(input));
            unPicketDroids.remove(input);
        }
        if (team1.droids().size() != team2.droids().size()
                && input == i){
            System.out.println("bug");
            pickUpDroid(team);
        }
        if (team1.droids().size() == team2.droids().size()
                && input == i)
            return -1;
        return 1;
    }

}
