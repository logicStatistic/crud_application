package com.kingsley.fullstackbackend.controller;

import com.kingsley.fullstackbackend.model.Member;
import com.kingsley.fullstackbackend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ap1/v1/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/")
    public ResponseEntity<Member> registerMember(@RequestBody Member member){
        return new ResponseEntity<Member>(memberService.registerMember(member), HttpStatus.CREATED);
    }

    @GetMapping("/get-members")
    public ResponseEntity<List<Member>> getAllMembers(){
        return new ResponseEntity<List<Member>>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMember(@PathVariable("id") Long id){
        Boolean deleted = true;
        memberService.deleteMember(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

   @GetMapping("/member/{id}")

    public ResponseEntity<Member> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Member>(memberService.findById(id), HttpStatus.OK);
   }
}
