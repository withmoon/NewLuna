package com.study.luna.user.comment.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.user.comment.vo.EventReplyVO;

public interface EventReplyService {
	public List<EventReplyVO> eReplyList(int seq, int start, int end, HttpSession session); //댓글 목록
	public int counteReply(int rno); //글 갯수
	public void create(EventReplyVO eReplyVO); //댓글 입력
	public void eReplyUp(EventReplyVO eReplyVO); //댓글 수정
	public void eReplyDe(EventReplyVO eReplyVO); //댓글 삭제
}
