package com.study.luna.user.payandreserv.dao.Impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.payandreserv.dao.GetUserPayCountDAO;
@Repository
public class GetUserPayCountDAOImpl implements GetUserPayCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getUserPayCount(String status, String id,String startdate,String enddate) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("id", id);
		map.put("startdate", startdate);
		map.put("enddate", enddate);
		return sqlSession.selectOne("payAndReservDAO.getUserPayCount",map);
	}

}
