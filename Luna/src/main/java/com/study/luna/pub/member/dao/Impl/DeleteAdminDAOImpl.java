package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.DeleteAdminDAO;
@Repository
public class DeleteAdminDAOImpl implements DeleteAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteAdmin(String id) {
		sqlSession.delete("memberDAO.deleteAdmin",id);
	}

}
