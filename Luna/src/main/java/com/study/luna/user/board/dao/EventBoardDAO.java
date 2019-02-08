package com.study.luna.user.board.dao;

import java.util.List;

import com.study.luna.user.board.vo.EventBoardVO;

public interface EventBoardDAO {
	public List<EventBoardVO> eventList(EventBoardVO ebVO);
}
