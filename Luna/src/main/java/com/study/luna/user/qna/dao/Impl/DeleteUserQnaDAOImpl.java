package com.study.luna.user.qna.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.qna.dao.DeleteUserQnaDAO;
@Repository
public class DeleteUserQnaDAOImpl implements DeleteUserQnaDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteUserQna(int seq) {
		sqlSession.delete("mgQBoard.deleteUserQna",seq);
	}

}
