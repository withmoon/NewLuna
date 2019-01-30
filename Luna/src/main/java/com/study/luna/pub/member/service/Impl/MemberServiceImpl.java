package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.InsertMemberDAOImpl;
import com.study.luna.pub.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	IdCheckDAOImpl idchkDAOImpl;
	@Autowired
	InsertMemberDAOImpl instMemberDAOImpl;
	
	@Override
	public Integer idCheck(MemberCommand memcom) {		
		return idchkDAOImpl.idCheck(memcom);
	}

	@Override
	public void insertMember(MemberCommand memcom) {
		instMemberDAOImpl.insertMember(memcom);
	}
	
}
