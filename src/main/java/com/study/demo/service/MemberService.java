package com.study.demo.service;

import com.study.demo.dto.MemberResponse;
import com.study.demo.entity.Member;
import com.study.demo.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse.MemberInfoDto findMemberByUserName(String userName){
        Member member = memberRepository.findByUserName(userName)
                .orElseThrow( () -> new IllegalArgumentException("일치하는 멤버가 없습니다.") );

        log.info("조회된 멤버 userName: {}", member.getUserName());

        return MemberResponse.MemberInfoDto.builder()
                .id(member.getId())
                .userName(member.getUserName())
                .nickName(member.getNickName())
                .age(member.getAge())
                .profileImage(member.getProfileImage())
                .isMember(true)
                .build();
    }

    @Transactional
    public MemberResponse.MemberInfoDto updateMemberNickName(Long memberId, String nickName){
        Member member = memberRepository.findById(memberId)
                .orElseThrow( () -> new IllegalArgumentException("일치하는 멤버가 없습니다.") );

        member.setNickName(nickName);

        log.info("변경된 멤버 nickName: {}", member.getNickName());

        return MemberResponse.MemberInfoDto.builder()
                .id(member.getId())
                .userName(member.getUserName())
                .nickName(member.getNickName())
                .age(member.getAge())
                .profileImage(member.getProfileImage())
                .isMember(true)
                .build();
    }

    public List<Member> findAllMembers(){
        List<Member> allMembers = memberRepository.findAll();
        allMembers.forEach(member -> log.info(member.getUserName()));

        return allMembers;
    }
}