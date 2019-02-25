package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.user.comment.vo.EventReplyVO;

public interface EventReplyService {
	public void create(EventReplyVO eReplyVO); //댓글 입력
	public List<EventReplyVO> eReplyList(int seq); //댓글목록
}
