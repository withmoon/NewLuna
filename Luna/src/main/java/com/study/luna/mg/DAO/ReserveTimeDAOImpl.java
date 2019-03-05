package com.study.luna.mg.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.ReserveTimeVO;

@Repository
public class ReserveTimeDAOImpl implements ReserveTimeDAO {

	@Autowired
	private SqlSession SqlSession;
	
	
	 
	@Override
	public List<ReserveTimeVO> mgAgeList() {
		// TODO Auto-generated method stub
		return SqlSession.selectList("mgReserveTime.mgAgeList");
	}

}
