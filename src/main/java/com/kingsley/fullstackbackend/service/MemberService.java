package com.kingsley.fullstackbackend.service;

import com.kingsley.fullstackbackend.model.Member;
import com.kingsley.fullstackbackend.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member registerMember(Member member) {

        Member newMember = new Member();
        BeanUtils.copyProperties(member, newMember);
        return memberRepository.save(newMember);
    }
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void deleteMember(Long id) {
        memberRepository.deleteAllById(Collections.singleton(id));

    }

    public Member findById(Long id) {

        Member aMember = memberRepository.findById(id).get();
        return (Member) memberRepository.findById(aMember);
    }
}
