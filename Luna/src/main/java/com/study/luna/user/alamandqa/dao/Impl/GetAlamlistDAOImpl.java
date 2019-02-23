package com.study.luna.user.alamandqa.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.alamandqa.dao.GetAlamlistDAO;
import com.study.luna.user.dto.AlamDTO;
@Repository
public class GetAlamlistDAOImpl implements GetAlamlistDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<AlamDTO> getAlamlist(MemberCommand memcom) {
		return sqlSession.selectList("alamDAO.getAlamlist",memcom);
	}

}
