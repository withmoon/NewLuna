package com.study.luna.user.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.board.dao.EventBoardDAOImpl;
import com.study.luna.user.board.vo.EventBoardVO;

@Service
public class EventBoardServiceImpl implements EventBoardService {
	@Autowired
	EventBoardDAOImpl eventBoardImpl;

	//이벤트 목록
	@Override
	public List<EventBoardVO> eventList(EventBoardVO ebVO) {
		return eventBoardImpl.eventList(ebVO);
	}

	//이벤트 상세보기
	@Override
	public EventBoardVO read(int seq) throws Exception {
		return eventBoardImpl.read(seq);
	}

}
