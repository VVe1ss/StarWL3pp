package com.lw3.game;

import com.lw3.game.team.Team;

public abstract class Game {
    protected Team team1;
    protected Team team2;

    public abstract void run();
}
