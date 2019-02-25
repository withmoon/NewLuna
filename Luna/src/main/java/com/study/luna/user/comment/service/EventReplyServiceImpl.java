package com.study.luna.user.comment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.comment.dao.EventReplyDAOImpl;
import com.study.luna.user.comment.vo.EventReplyVO;

@Service
public class EventReplyServiceImpl implements EventReplyService {
	@Autowired
	EventReplyDAOImpl eventReplyDAOImpl;
	
	//댓글 입력
	@Override
	public void create(EventReplyVO eReplyVO) {
		eventReplyDAOImpl.create(eReplyVO);
	}

	//댓글 목록
	@Override
	public List<EventReplyVO> eReplyList(int seq) {
		return eventReplyDAOImpl.eReplyList(seq);
	}

}
