package com.study.luna.user.qna.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.user.qna.dao.GetUserQnAllDAO;
@Repository
public class GetUserQnAllDAOImpl implements GetUserQnAllDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public List<QBoardVO> getUserQnAll(int start,int end,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("mgQBoard.getUserQnAll",map);
	}

}
