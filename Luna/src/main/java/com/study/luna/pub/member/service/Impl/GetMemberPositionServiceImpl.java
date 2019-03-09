package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.MemberDAO;
import com.study.luna.pub.member.service.GetMemberPositionService;
@Service
public class GetMemberPositionServiceImpl implements GetMemberPositionService {
	
	@Autowired
	MemberDAO memd;

	@Override
	public MemberCommand getMemberPosition(String id) {
		return memd.getMemberPosition(id);
	}

}
