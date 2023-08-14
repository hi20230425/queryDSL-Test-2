package com.mysite.queryDSLTest2.entity;

import java.util.List;

import org.apache.groovy.parser.antlr4.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

	private JPAQueryFactory jpaQueryFactory; 
	
	public MemberRepositoryCustomImpl(EntityManager em) {
		this.jpaQueryFactory = new JPAQueryFactory(em); 
	}
	
	
	//where 에서 사용되는 메소드 선언 
	private BooleanExpression searchName (String name) {		
		return StringUtils.isEmpty(name) ? null : QMember.member.name.like(name); 	 
	}
	private BooleanExpression searchEmail (String email) {
		return StringUtils.isEmpty(email) ? null : QMember.member.email.like(email); 
	}
	private BooleanExpression searchAddr (String addr) {
		return StringUtils.isEmpty(addr) ? null : QMember.member.addr.like(addr); 
	}
	

	@Override
	public List<Member> getMemberList(MemberDTO memberDTO) {

		List<Member> memberList = jpaQueryFactory
				.selectFrom(QMember.member)
				.where(searchName(memberDTO.getSearchName()))
				.where(searchEmail(memberDTO.getSearchEmail()))
				.where(searchAddr(memberDTO.getSearchAddr()))	
				.fetch(); 
		
		return memberList;
	}
	
	


}
