package com.study.luna.user.alamandqa.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.alamandqa.dao.GetAlamlistDAO;
import com.study.luna.user.dto.AlamDTO;
@Repository
public class GetAlamlistDAOImpl implements GetAlamlistDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<AlamDTO> getAlamlist(int start, int end,String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("alamDAO.getAlamlist",map);
	}

}
