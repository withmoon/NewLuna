package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.dao.CancleReserveDAO;
@Repository
public class CancleReserveDAOImpl implements CancleReserveDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void cancleReserve(MyPageInfoDTO mpif) {
		sqlSession.update("payAndReservDAO.cancleReserve",mpif);
	}

}
