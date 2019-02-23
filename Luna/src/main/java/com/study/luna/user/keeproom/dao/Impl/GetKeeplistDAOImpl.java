package com.study.luna.user.keeproom.dao.Impl;

import java.util.List;

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
	public List<RoomInfoDTO> getKeeplist(String id) {
		return sqlSession.selectList("keepRoomDAO.getKeeplist",id);
	}

}
