package com.study.luna.pub.howtouse.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
@Repository
public class HowToUseDAOImpl implements HowToUseDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertHowToUse(HowToUseDTO htu) {
		sqlSession.insert("htuDAO.insertHowToUse",htu);
	}

	@Override
	public List<HowToUseDTO> getHowToUseList() {
		return sqlSession.selectList("htuDAO.getHowToUseList");
	}

	@Override
	public Integer getHowToUseMaxNum() {
		return sqlSession.selectOne("htuDAO.getHowToUseMaxNum");
	}

	@Override
	public Integer getHowToUseMaxCnum() {
		return sqlSession.selectOne("htuDAO·getHowToUseMaxCnum");
	}

	@Override
	public HowToUseDTO getHowToUseContent(int num) {
		return sqlSession.selectOne("htuDAO.getHowToUseContent");
	}

}
