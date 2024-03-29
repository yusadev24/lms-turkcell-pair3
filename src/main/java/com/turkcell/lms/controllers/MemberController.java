package com.turkcell.lms.controllers;
import com.turkcell.lms.services.abstracts.MemberService;
import com.turkcell.lms.services.responses.GetAllMembersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/members/")
@RequiredArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/getall")
    public List<GetAllMembersResponse> getAll(){
        return memberService.getAll();
    }

}
