package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;
import com.study.luna.pub.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	IdCheckDAOImpl idchkDAOImpl;
	
	@Override
	public Integer idCheck(MemberCommand memcom) {
		System.out.println("serviceImpl 에서의 멤" +memcom.getId());
		
		return idchkDAOImpl.idCheck(memcom);
	}
	
}
