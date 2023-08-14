package com.mysite.queryDSLTest2.entity;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository; 
	
	public List<Member> getSearchMemberList(MemberDTO memberDTO ) {
		
		List<Member> memberList = memberRepository.getMemberList(memberDTO); 
		
		return memberList; 
	}
	
	
	
}
