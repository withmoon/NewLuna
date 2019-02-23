package com.study.luna.user.keeproom.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.keeproom.dao.KeeproomDAO;
@Repository
public class KeeproomDAOImpl implements KeeproomDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void keeproom(KeepRoomDTO krd) {
		sqlSession.insert("keepRoomDAO.keeproom",krd);
	}

}
