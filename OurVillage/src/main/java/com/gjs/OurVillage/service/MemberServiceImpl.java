package com.gjs.OurVillage.service;

import com.gjs.OurVillage.domain.Member;
import com.gjs.OurVillage.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void join(Member member){

        memberRepository.save(member);
    }

    @Override
    public void leave(Member member){
        memberRepository.delete(member);
    }

    @Override
    public Optional<Member> findMember(String memberId){
        return memberRepository.findById(memberId);
    }

    @Override
    public ArrayList<Member> findAllMembers(){
        ArrayList<Member> members = new ArrayList<>();
        Streamable.of(memberRepository.findAll()).forEach(members::add);
        return members;
    }

    private void validateDuplicateMember(Member member){
        if(memberRepository.existsById(member.getId())){
            System.out.println("duplicate member error");
            throw new IllegalStateException("duplicate member error");
        }
    }
}
