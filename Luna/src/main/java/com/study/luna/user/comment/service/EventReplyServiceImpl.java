package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.comment.dao.EventReplyDAOImpl;
import com.study.luna.user.comment.vo.EventReplyVO;

@Service
public class EventReplyServiceImpl implements EventReplyService {
	@Autowired
	EventReplyDAOImpl eventReplyDAOImpl;

	//댓글 목록
	@Override
	public List<EventReplyVO> eReplyList(int seq, int start, int end, HttpSession session) {
		return eventReplyDAOImpl.eReplyList(seq, start, end);
	}

	//댓글 갯수
	@Override
	public int counteReply(int rno) {
		return eventReplyDAOImpl.counteReply(rno);
	}

	//댓글 작성
	@Override
	public void create(EventReplyVO eReplyVO) {
		eventReplyDAOImpl.create(eReplyVO);
	}

	@Override
	public void eReplyUp(EventReplyVO eReplyVO) {
		eventReplyDAOImpl.eReplyUp(eReplyVO);
	}

	@Override
	public void eReplyDe(EventReplyVO eReplyVO) {
		eventReplyDAOImpl.eReplyDe(eReplyVO);
	}
	
}
