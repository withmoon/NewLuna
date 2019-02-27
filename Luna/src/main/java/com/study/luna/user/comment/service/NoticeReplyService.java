package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.user.comment.vo.NoticeReplyVO;

public interface NoticeReplyService {
	public List<NoticeReplyVO> nReplyList(int num, HttpSession session); //댓글 목록
	public void create(NoticeReplyVO nReplyVO); //댓글 입력
	

}
