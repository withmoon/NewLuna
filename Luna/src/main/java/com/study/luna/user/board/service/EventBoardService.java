package com.study.luna.user.board.service;

import java.util.List;

import com.study.luna.user.board.vo.EventBoardVO;


public interface EventBoardService {
	List<EventBoardVO> eventList(EventBoardVO ebVO); //이벤트목록
}
