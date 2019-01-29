package com.study.luna.pub.member.service.Impl;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;

public class TestClient {
	public static void main(String[] args) {

		IdCheckDAOImpl idsImpl = new IdCheckDAOImpl();

		MemberCommand mem = new MemberCommand();
		mem.setId("test");
		
		System.out.println(mem.toString());
		
		Integer result = idsImpl.idCheck(mem);
		
		System.out.println("결과값 : " + result);

	}
}
