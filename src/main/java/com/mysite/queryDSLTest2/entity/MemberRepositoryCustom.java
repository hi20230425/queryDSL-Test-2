package com.mysite.queryDSLTest2.entity;

import java.util.List;

public interface MemberRepositoryCustom {

	List<Member> getMemberList(MemberDTO memberDTO); 
}
