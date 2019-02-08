package com.study.luna.pub.member.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.MemberDAOImpl;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.DnStatusDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetBrNameDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetMyPageInfoDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetStatusDAOImpl;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.InsertMemberDAOImpl;
import com.study.luna.pub.member.dao.Impl.PassCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.UpStatusDAOImpl;
import com.study.luna.pub.member.dao.Impl.UpUserInfoDAOImpl;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.SHA256;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	IdCheckDAOImpl idchkDAOImpl;
	@Autowired
	InsertMemberDAOImpl instMemberDAOImpl;
	@Autowired
	PassCheckDAOImpl pcDAOimpl;
	@Autowired
	GetBrNameDAOImpl getbrDAOImpl;
	@Autowired
	GetStatusDAOImpl getStDAOImpl;
	@Autowired
	UpStatusDAOImpl upStDAOImpl;
	@Autowired
	DnStatusDAOImpl dnStDAOImpl;
	@Autowired
	GetMyPageInfoDAOImpl getMyInfoDAOImpl;
	@Autowired
	UpUserInfoDAOImpl upUsInfDAOImpl;
	@Autowired
	MemberDAOImpl memberDAOImpl;
	
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

	@Override
	public String getBrName(String id) {
		return getbrDAOImpl.getBrName(id);
	}

	@Override
	public int getStatus(MemberCommand memcom) {
		return getStDAOImpl.getStatus(memcom);
	}

	@Override
	public void upStatus(MemberCommand memcom) {
		upStDAOImpl.upStatus(memcom);		
	}

	@Override
	public void dnStatus(MemberCommand memcom) {
		dnStDAOImpl.dnStatus(memcom);
	}

	@Override
	public MemberCommand getMyPageInfo(MemberCommand memcom) {
		return getMyInfoDAOImpl.getMyPageInfo(memcom);
	}

	@Override
	public void upUserInfo(MemberCommand memcom) {
		upUsInfDAOImpl.upUserInfo(memcom);
	}

	@Override
	public List<MemberCommand> memberList(MemberCommand mc) {
		return memberDAOImpl.memberList(mc);
	}
	
}
