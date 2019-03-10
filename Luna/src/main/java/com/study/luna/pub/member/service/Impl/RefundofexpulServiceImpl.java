package com.study.luna.pub.member.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.member.dao.MemberDAO;
import com.study.luna.pub.member.service.RefundofexpulService;
@Service
public class RefundofexpulServiceImpl implements RefundofexpulService {
	
	@Autowired
	MemberDAO memDAO;

	@Override
	public void refundofexpul(String id) {
		memDAO.refundofexpul(id);
	}

}
