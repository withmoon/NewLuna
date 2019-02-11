package com.study.luna.user.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.board.vo.EventBoardVO;

@Repository
public class EventBoardDAOImpl implements EventBoardDAO  {
	@Autowired
	SqlSessionTemplate SqlSession;

	//이벤트 목록
	@Override
	public List<EventBoardVO> eventList(EventBoardVO ebVO) {
		System.out.println("===> 이벤트 목록");
		return SqlSession.selectList("eventBoardDAO.eventList", ebVO);
	}

	//이벤트 상세보기
	@Override
	public EventBoardVO read(int seq) throws Exception {
		System.out.println("===> 이벤트 상세보기");
		return SqlSession.selectOne("eventBoardDAO.viewEvent", seq);
	}

}
