package com.study.luna.user.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.board.vo.EventBoardVO;

@Repository
public class EventBoardDAOImpl implements EventBoardDAO  {
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public List<EventBoardVO> eventList(EventBoardVO ebVO) {
		System.out.println("===> 이벤트목록");
		return sqlSession.selectList("eventBoardDAO.eventList", ebVO);
	}

}
