package com.study.luna.user.payandreserv.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.dao.GetUserPayInfoDAO;

@Repository
public class GetUserPayInfoDAOImpl implements GetUserPayInfoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		map.put("startdate",startdate);
		map.put("enddate", enddate);
		return sqlSession.selectList("payAndReservDAO.getUserPayInfo",map);
	}

}
