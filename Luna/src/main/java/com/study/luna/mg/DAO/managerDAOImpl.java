package com.study.luna.mg.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class managerDAOImpl implements managerDAO{

	@Autowired 
	private SqlSession SqlSession;
	//�α��μ�
	@Override
	public int login() {
		System.out.println("logincount DAO");
		return SqlSession.selectOne("managerDAO.login");
	}
	
	//�α��μ�+1
	@Override
	public void logincount() {
		System.out.println("logincount+1 DAO");
		SqlSession.update("managerDAO.logincount");
	}

}
