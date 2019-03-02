package com.study.luna.user.qna.dao.Impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.qna.dao.UpUserQnaContentDAO;
@Repository
public class UpUserQnaContentDAOImpl implements UpUserQnaContentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void upUserQnaContent(int seq, String content) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("seq", seq);
		map.put("content", content);
		sqlSession.update("upUserQnaContent",map);
	}

}
