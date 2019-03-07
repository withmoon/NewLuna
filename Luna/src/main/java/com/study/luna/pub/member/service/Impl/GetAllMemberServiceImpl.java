package com.study.luna.pub.member.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.MemberDAO;
import com.study.luna.pub.member.service.GetAllMemberService;
@Service
public class GetAllMemberServiceImpl implements GetAllMemberService {
	
	@Autowired
	MemberDAO memd;

	@Override
	public List<MemberCommand> getAllMember(int start,int end,String searchOption, String keyword) {
		return memd.getAllMember(start,end,searchOption, keyword);
	}

}
