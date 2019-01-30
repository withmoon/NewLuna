package com.study.luna.pub.member.service.Impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;

public class TestClient {
	public static void main(String[] args) {
		
		ApplicationContext context=new GenericXmlApplicationContext("classpath:applicationContext.xml");  
		
		MemberServiceImpl idsImpl=context.getBean("memberServiceImpl",MemberServiceImpl.class);
		
		MemberCommand mem = new MemberCommand(); 
		  
		  mem.setId("test1");
		  
		  Integer result = idsImpl.idCheck(mem);
		  
		  System.out.println("결과값 : " + result);
	}
}
