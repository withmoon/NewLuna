package com.study.luna.user.payandreserv.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.dao.GetUserPayInfoDAO;

@Repository
public class GetUserPayInfoDAOImpl implements GetUserPayInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyPageInfoDTO> getUserPayInfo(MemberCommand memcom) {
		return sqlSession.selectList("payAndReservDAO.getUserPayInfo",memcom);
	}

}
