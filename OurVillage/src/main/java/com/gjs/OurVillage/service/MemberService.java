package com.gjs.OurVillage.service;

import com.gjs.OurVillage.domain.Member;

import java.util.ArrayList;
import java.util.Optional;

public interface MemberService {

    void join(Member member);

    void leave(Member member);

    Optional<Member> findMember (String memberId);

    ArrayList<Member> findAllMembers();
}
