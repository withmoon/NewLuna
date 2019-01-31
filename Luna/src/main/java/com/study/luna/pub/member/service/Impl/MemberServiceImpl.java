package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.InsertMemberDAOImpl;
import com.study.luna.pub.member.dao.Impl.PassCheckDAOImpl;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.BCrypt;
import com.study.luna.util.SHA256;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	IdCheckDAOImpl idchkDAOImpl;
	@Autowired
	InsertMemberDAOImpl instMemberDAOImpl;
	@Autowired
	PassCheckDAOImpl pcDAOimpl;
	
	@Override
	public Integer idCheck(MemberCommand memcom) {		
		return idchkDAOImpl.idCheck(memcom);
	}

	@Override
	public void insertMember(MemberCommand memcom) {
		instMemberDAOImpl.insertMember(memcom);
	}

	@Override
	public boolean passCheck(String id,String pass) throws Exception {
		String realpass=pcDAOimpl.getPass(id);
		
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(pass.getBytes());
		
		boolean result=realpass.equals(shaPass)? true :false;
		
		return result;
	}
	
}
