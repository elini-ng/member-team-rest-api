package com.estsoft.memberteamrestapi.service;

import com.estsoft.memberteamrestapi.repository.Member;
import com.estsoft.memberteamrestapi.repository.MemberRepository;
import com.estsoft.memberteamrestapi.repository.Team;
import com.estsoft.memberteamrestapi.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    //Get all member info
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    //Insert new member
    public Member addMember(Long teamId, Member member) {
        String memberName = member.getName();

        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team id " + teamId + " is not found"));

        if (memberName == null || memberName.trim().isEmpty()){
            throw new IllegalArgumentException("Member name cannot be null or empty");
        }

        member.setTeam(team);
        return memberRepository.save(member);
    }
}
