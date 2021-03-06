package com.jason.controller;

import com.jason.domain.Member;
import com.jason.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Jason on 2016-09-04.
 */
@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    @ResponseBody
    public List<Member> findMembers() {
        return memberService.findMembers();
    }

    @RequestMapping("/{memberName}")
    @ResponseBody
    public List<Member> findMembersByName(@PathVariable("memberName") String memberName) {
        return memberService.findMembersByName(memberName);
    }

    @RequestMapping("/members/{memberName}")
    @ResponseBody
    public List<Member> findMembersByName2(@PathVariable("memberName") String memberName) {
        return memberService.findMembersByName2(memberName);
    }
}