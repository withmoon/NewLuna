package com.study.luna.user.comment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.comment.vo.EventReplyVO;

@Repository
public class EventReplyDAOImpl implements EventReplyDAO {
	@Autowired
	SqlSessionTemplate SqlSession;
	
	//댓글 입력
	public void create(EventReplyVO eReplyVO) {
		SqlSession.insert("eventReplyDAO.eReplyInsert", eReplyVO);
	}

	//댓글 목록
	@Override
	public List<EventReplyVO> eReplyList(int seq) {
		return SqlSession.selectList("eventReplyDAO.eReplyList", seq);
	}
}
