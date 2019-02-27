package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.comment.dao.NoticeReplyDAOImpl;
import com.study.luna.user.comment.vo.NoticeReplyVO;

@Service
public class NoticeReplyServiceImpl implements NoticeReplyService {
	@Autowired
	NoticeReplyDAOImpl noticeReplyDAOImpl;
	
	//댓글 목록
	@Override
	public List<NoticeReplyVO> nReplyList(int num, HttpSession session) {
		return noticeReplyDAOImpl.nReplyList(num);
	}
	
	//댓글 작성
	@Override
	public void create(NoticeReplyVO nReplyVO) {
		noticeReplyDAOImpl.create(nReplyVO);
	}

	
}
