package com.study.luna.user.board.dao;

import java.util.List;

import com.study.luna.user.board.vo.EventBoardVO;

public interface EventBoardDAO {
	public List<EventBoardVO> eventList(EventBoardVO ebVO); //이벤트 목록
	public EventBoardVO read(int seq) throws Exception; //이벤트 상세보기
}