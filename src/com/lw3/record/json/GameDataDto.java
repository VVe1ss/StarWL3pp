package com.lw3.record.json;

import com.lw3.game.team.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class GameDataDto {
    private String time;
    private Team team1;
    private Team team2;
    private boolean firstTeamAttacks;
    private String moves;
}
