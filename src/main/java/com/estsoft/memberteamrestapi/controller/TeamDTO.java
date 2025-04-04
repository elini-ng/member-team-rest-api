package com.estsoft.memberteamrestapi.controller;

import com.estsoft.memberteamrestapi.repository.Team;
import lombok.Getter;

@Getter
public class TeamDTO {
    private Long teamId;
    private String name;

    public TeamDTO(Team team) {
        teamId = team.getId();
        name = team.getName();
    }
}
