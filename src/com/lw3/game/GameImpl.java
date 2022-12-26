package com.lw3.game;

import com.lw3.attacks.Attack;
import com.lw3.droids.Droid;
import com.lw3.game.team.Team;
import com.lw3.record.json.GameDataDto;
import com.lw3.record.json.JsonConverter;
import com.lw3.record.json.JsonConverterData;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameImpl extends Game implements ChooseDroid{
    private boolean firstTeamAttacks;
    private boolean recordedGame;
    private final StringBuilder moves = new StringBuilder();
    private int round = 1;
    private GameDataDto gameDataDto;
    private final InputStream defaultInputStream = System.in;
    private final Print printer = new Print();
    private final Scanner sc;

    public GameImpl(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;

        firstRoundRandom();
        this.gameDataDto = GameDataDto.builder()
                .team1(new Team(team1))
                .team2(new Team(team2))
                .firstTeamAttacks(firstTeamAttacks)
                .build();
        this.sc = new Scanner(System.in);
    }

    public GameImpl(GameDataDto gameDataDto){
        this.team1 = gameDataDto.getTeam1();
        this.team2 = gameDataDto.getTeam2();
        firstTeamAttacks = gameDataDto.isFirstTeamAttacks();
        this.recordedGame = true;
        System.setIn(new ByteArrayInputStream(gameDataDto.getMoves().getBytes()));
        this.sc = new Scanner(System.in);
    }

    @Override
    public void run() {
        Team attackerTeam;
        Team defendingTeam;
        if (firstTeamAttacks){
            attackerTeam = team1;
            defendingTeam = team2;
        } else {
            attackerTeam = team2;
            defendingTeam = team1;
        }
        printRound(attackerTeam, defendingTeam);
        move(attackerTeam,defendingTeam);
        gameEndOrNextRound(attackerTeam,defendingTeam);
    }

    private void printRound(Team attackerTeam, Team defendingTeam){
        printer.roundInfo(attackerTeam,defendingTeam);
        printer.printDroidsInfo(attackerTeam,defendingTeam);
    }

    private void gameEndOrNextRound(Team attackerTeam, Team defendingTeam){
        if (defendingTeam.droids().stream().noneMatch(droid -> droid.getHp() > 0)) {
            System.out.printf("\n%s перемогли", attackerTeam.name());
            if (!recordedGame)
                recordGame();
            else
                System.setIn(defaultInputStream);
        }
        else {
            firstTeamAttacks = !firstTeamAttacks;
            attackerTeamAttacksDecreaseCooldown(attackerTeam);
            round++;
            this.run();
        }
    }

    private void move(Team attackerTeam, Team defendingTeam){
        Droid atcDroid = chooseDroid(attackerTeam, true, moves, recordedGame, sc);
        Attack attack = atcDroid.getAttacks().get(chooseAttack(atcDroid)-1);
        while (!attack.prepareAndAttack(atcDroid,attackerTeam,defendingTeam,moves,recordedGame, sc)){
            System.out.printf("Ця атака ще не відновилася, зачекайте ще %d ходів", attack.getCoolDown());
            attack = atcDroid.getAttacks().get(chooseAttack(atcDroid)-1);
        }
    }

    private int chooseAttack(Droid atcDroid) {
        StringBuilder sb = new StringBuilder("\n" +
                "Виберіть атаку" +
                "\nДля інформації про атаку дублюйте її номер\n");
        int input;
        for (int i = 0; i < 3; i++) {
            sb.append(String.format("\n| %d-> %s", i+1, atcDroid.getAttacks().get(i).getName()));
        }
        do {
            System.out.println(sb);
            input = sc.nextInt();
            if (recordedGame)
                System.out.println(input);
            moves.append(input).append(" ");
            if (input == 11)
                System.out.println(atcDroid.getAttacks().get(0).getShortDesc());
            if (input == 22)
                System.out.println(atcDroid.getAttacks().get(1).getShortDesc());
            if (input == 33)
                System.out.println(atcDroid.getAttacks().get(2).getShortDesc());
        }
        while (input<1 || input>3);
        return input;
    }

    private void attackerTeamAttacksDecreaseCooldown(Team attackerTeam) {
        attackerTeam.droids().forEach(
                droid -> droid.getAttacks().forEach(Attack::reduceCoolDown)
        );
    }

    private void firstRoundRandom(){
        if (round == 1) {
            firstTeamAttacks = new Random().nextBoolean();
            if (firstTeamAttacks)
                System.out.println("Team "+team1.name()+ " attacks first");
            else
                System.out.println("Team "+team2.name()+" attacks first");
        }
    }

    private void recordGame(){
        JsonConverterData jsonConverterData = JsonConverter.convertToJsonConverterData();

        gameDataDto.setTime(LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm")));
        gameDataDto.setMoves(moves.toString());

        jsonConverterData.getGames().add(gameDataDto);
        JsonConverter.convertToJson(jsonConverterData);
    }

/** print class prints some information game needs */
    private class Print {
        private void roundInfo(Team atcTeam, Team defTeam){
            String sb = String.format("--------------------------Round №%d---------------------------", round) +
                    "\n|\t\t" +
                    atcTeam.name() +
                    spacesPerNumber(20 - atcTeam.name().length()) +
                    "->" + "\t\t " +
                    defTeam.name() +
                    spacesPerNumber(20 - defTeam.name().length()) + "\t|";
            System.out.println(sb);
        }

        private void printDroidsInfo(Team attackerTeam, Team defendingTeam){
            for (int i = 0; i < attackerTeam.droids().size(); i++) {
                printPairOfDroids(attackerTeam.droids().get(i),defendingTeam.droids().get(i));
            }
            System.out.println("-------------------------------------------------------------");
        }

        private void printPairOfDroids(Droid attackerTeamDroid, Droid defendingTeamDroid) {
            StringBuilder sb = new StringBuilder();
            String s = String.format("""
                        |                                                         \t|
                        |\tdroid:\t%s%s\t\tdroid:\t%s%s|
                        |\ttype :\t%s%s\t\ttype :\t%s%s|
                        |\thp  =\t%s%s\t\thp  =\t%s%s|
                        |\tatc =\t%s%s\t\tatc =\t%s%s|
                        |\tdef =\t%s%s\t\tdef =\t%s%s|""",
                    attackerTeamDroid.getName(),
                    spacesPerNumber(16- attackerTeamDroid.getName().chars().count()),
                    defendingTeamDroid.getName(),
                    spacesPerNumber(16- defendingTeamDroid.getName().chars().count()),
                    attackerTeamDroid.getClass().getSimpleName(),
                    spacesPerNumber(16- attackerTeamDroid.getClass().getSimpleName().chars().count()),
                    defendingTeamDroid.getClass().getSimpleName(),
                    spacesPerNumber(16- defendingTeamDroid.getClass().getSimpleName().chars().count()),
                    attackerTeamDroid.getHp(),
                    spacesPerNumber(16-String.valueOf(attackerTeamDroid.getHp()).chars().count()),
                    defendingTeamDroid.getHp(),
                    spacesPerNumber(16-String.valueOf(defendingTeamDroid.getHp()).chars().count()),
                    attackerTeamDroid.getAtc(),
                    spacesPerNumber(16-String.valueOf(attackerTeamDroid.getAtc()).chars().count()),
                    defendingTeamDroid.getAtc(),
                    spacesPerNumber(16-String.valueOf(defendingTeamDroid.getAtc()).chars().count()),
                    attackerTeamDroid.getDefence(),
                    spacesPerNumber(16-String.valueOf(attackerTeamDroid.getDefence()).chars().count()),
                    defendingTeamDroid.getDefence(),
                    spacesPerNumber(16-String.valueOf(defendingTeamDroid.getDefence()).chars().count())

            );
            sb.append(s);
//        sb.append("\n-------------------------------------------------------------");
            System.out.println(sb);
        }

        private String spacesPerNumber(long spaces) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < spaces; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
    }



}


