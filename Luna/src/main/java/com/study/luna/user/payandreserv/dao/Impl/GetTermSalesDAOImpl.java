package com.study.luna.user.payandreserv.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.payandreserv.dao.GetTermSalesDAO;
@Repository
public class GetTermSalesDAOImpl implements GetTermSalesDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<RoomPaymentDTO> getTermSales(String paid_at_start, String paid_at_end) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("paid_at_start", paid_at_start);
		map.put("paid_at_end", paid_at_end);
		return sqlSession.selectList("payAndReservDAO.getTermSales",map);
	}

}
