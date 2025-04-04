package com.estsoft.memberteamrestapi.service;

import com.estsoft.memberteamrestapi.repository.Team;
import com.estsoft.memberteamrestapi.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    //Get all team info
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    //Insert new team
    public Team addTeam(Team team) {
        String teamName = team.getName();

        //Validation check
        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }

        //Save data
        return teamRepository.save(team);
    }

    //Change team name
    public Team updateTeam(Team team) {
        Long id = team.getId();
        String teamName = team.getName();

        //Validation check
        Team existingTeam = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Team id " + id + " is not found"));

        if (teamName == null || teamName.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name cannot be null or empty");
        }

        //Update data
        existingTeam.setName(team.getName());
        return teamRepository.save(team);
    }
}
