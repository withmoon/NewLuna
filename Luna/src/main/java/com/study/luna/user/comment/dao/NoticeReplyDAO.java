package com.study.luna.user.comment.dao;

import java.util.List;

import com.study.luna.user.comment.vo.NoticeReplyVO;

public interface NoticeReplyDAO {
	public List<NoticeReplyVO> nReplyList(int num, int start, int end); //댓글 목록
	public int countnReply(int rno); //글 갯수
	public void create(NoticeReplyVO nReplyVO); //댓글 입력
	public void nReplyUp(NoticeReplyVO nReplyVO); //댓글 입력
	public void nReplyDe(NoticeReplyVO nReplyVO); //댓글 삭제
}
