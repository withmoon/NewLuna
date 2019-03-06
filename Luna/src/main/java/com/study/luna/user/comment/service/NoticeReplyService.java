package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.user.comment.vo.NoticeReplyVO;

public interface NoticeReplyService {
	public List<NoticeReplyVO> nReplyList(int num,int start, int end, HttpSession session); //댓글 목록
	public int countnReply(int rno); //글 갯수
	public void create(NoticeReplyVO nReplyVO); //댓글 입력
}
