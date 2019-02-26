package com.study.luna.user.keeproom.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.keeproom.dao.GetKeepListDAO;
@Repository
public class GetKeeplistDAOImpl implements GetKeepListDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<RoomInfoDTO> getKeeplist(int start, int end,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("keepRoomDAO.getKeeplist",map);
	}

}
