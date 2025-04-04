package com.estsoft.memberteamrestapi.controller;

import com.estsoft.memberteamrestapi.repository.Team;
import lombok.Getter;

@Getter
public class TeamDTO {
    private final Long teamId;
    private final String name;

    public TeamDTO(Team team) {
        teamId = team.getId();
        name = team.getName();
    }
}
