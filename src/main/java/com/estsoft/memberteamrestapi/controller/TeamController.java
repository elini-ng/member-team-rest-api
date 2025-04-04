package com.estsoft.memberteamrestapi.controller;

import com.estsoft.memberteamrestapi.repository.Team;
import com.estsoft.memberteamrestapi.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDTO> getTeamList() {
        List<Team> teamList = teamService.getTeams();
        return teamList.stream()
                .map(team -> new TeamDTO(team))
                .toList();
    }

    @PostMapping("/teams")
    public Team addNewTeam(@RequestBody Team team) {
        return teamService.addTeam(team);
    }

    @PutMapping("/teams/{id}")
    public TeamDTO updateTeam(@PathVariable Long id,
        @RequestBody Team team) {
        team.setId(id);
        return new TeamDTO(teamService.updateTeam(team));
    }

}
