package com.icia.member.controller;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {
//    @GetMapping("/ajax01")
//    public String ajax01() {
//        System.out.println("AjaxController.ajax01");
//        return "index";
//    }

    @GetMapping("/ajax01")
    public @ResponseBody String ajax01() {
        System.out.println("AjaxController.ajax01");
        return "index";
    }

    @PostMapping(value = "/ajax02", produces = "application/text; charset=utf-8")
    public @ResponseBody String ajax02() {
        System.out.println("AjaxController.ajax02");
        return "안녕하세요 저는 리턴입니다.";
    }

    @GetMapping("/ajax03")
    public @ResponseBody String ajax03(@RequestParam("param1") String param1,
                                       @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        return "good";
    }

    @PostMapping("/ajax04")
    public @ResponseBody String ajax04(@RequestParam("param1") String param1,
                                       @RequestParam("param2") String param2,
                                       @RequestParam("qqq") String qqq) {
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", qqq = " + qqq);
        return "good";
    }

//    @GetMapping("/ajax05")
//    public @ResponseBody String ajax05(@ModelAttribute MemberDTO memberDTO) {
//        System.out.println("memberDTO = " + memberDTO);
//        return "ok";
//    }

    @GetMapping("/ajax05")
    public @ResponseBody MemberDTO ajax05(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return memberDTO;
    }

    @Autowired
    private MemberService memberService;

    @GetMapping("/ajax06")
    public @ResponseBody List<MemberDTO> ajax06() {
       List<MemberDTO> memberDTOList = memberService.findAll();
       return memberDTOList;
    }

    @PostMapping("/ajax07")
    public @ResponseBody MemberDTO ajax07(@RequestBody MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return memberDTO;
    }

    @PostMapping("/ajax08")
    public @ResponseBody List<MemberDTO> ajax08(@RequestBody MemberDTO memberDTO) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        memberDTOList.add(memberDTO);
        return memberDTOList;
    }

    @PostMapping("/ajax09")
    public ResponseEntity ajax09(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }
    // REST API, restful api
    @PostMapping("/ajax10")
    public ResponseEntity ajax10(@RequestBody MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        List<MemberDTO> memberDTOList = memberService.findAll();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("member", memberDTO);
        resultMap.put("memberList", memberDTOList);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}