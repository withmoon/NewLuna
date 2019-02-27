package com.study.luna.user.comment.dao;

import java.util.List;

import com.study.luna.user.comment.vo.NoticeReplyVO;

public interface NoticeReplyDAO {
	public List<NoticeReplyVO> nReplyList(int num); //댓글 목록
	public void create(NoticeReplyVO nReplyVO); //댓글 입력
}
