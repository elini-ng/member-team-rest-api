package com.estsoft.memberteamrestapi.controller;

import com.estsoft.memberteamrestapi.repository.Member;
import lombok.Getter;

@Getter
public class MemberDTO {
    private Long id;
    private String name;
    private TeamDTO team;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.team = new TeamDTO(member.getTeam());
    }
}
