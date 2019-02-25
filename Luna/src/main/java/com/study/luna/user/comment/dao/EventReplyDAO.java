package com.study.luna.user.comment.dao;

import java.util.List;

import com.study.luna.user.comment.vo.EventReplyVO;

public interface EventReplyDAO {
	public void create(EventReplyVO vo); //댓글 입력
	public List<EventReplyVO> eReplyList(int seq); //댓글목록
}
