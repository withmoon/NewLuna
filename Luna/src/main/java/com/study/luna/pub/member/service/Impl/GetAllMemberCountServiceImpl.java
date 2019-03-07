package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.member.dao.MemberDAO;
import com.study.luna.pub.member.service.GetAllMemberCountService;
@Service
public class GetAllMemberCountServiceImpl implements GetAllMemberCountService {
	@Autowired
	MemberDAO memd;
	
	@Override
	public Integer getAllMemberCount(String searchOption, String keyword) {
		return memd.getAllMemberCount(searchOption, keyword);
	}

}
