package com.estsoft.memberteamrestapi.controller;

import com.estsoft.memberteamrestapi.repository.Member;
import com.estsoft.memberteamrestapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public List<MemberDTO> getMemberList() {
        List<Member> memberList = memberService.getMembers();
        return memberList.stream()
                .map(member -> new MemberDTO(member))
                .toList();
    }

    @PostMapping("/teams/{id}/members")
    public MemberDTO addNewMember(@PathVariable Long id,
        @RequestBody Member member) {
        return new MemberDTO(memberService.addMember(id, member));
    }
}
