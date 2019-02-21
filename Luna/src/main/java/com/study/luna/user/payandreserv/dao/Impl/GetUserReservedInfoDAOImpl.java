package com.study.luna.user.payandreserv.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.dao.GetUserReservedInfoDAO;

@Repository
public class GetUserReservedInfoDAOImpl implements GetUserReservedInfoDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MyPageInfoDTO> getUserReservedInfo(MemberCommand memcom) {
		return sqlSession.selectList("payAndReservDAO.getUserReservedInfo",memcom);
	}

}
