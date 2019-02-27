package com.study.luna.user.comment.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.comment.vo.EventReplyVO;
import com.study.luna.user.comment.vo.NoticeReplyVO;

@Repository
public class NoticeReplyDAOImpl implements NoticeReplyDAO {
	@Autowired
	SqlSessionTemplate SqlSession;

	public void create(NoticeReplyVO nReplyVO) {
		SqlSession.insert("noticeReplyDAO.nReplyInsert", nReplyVO);
	}

	public List<NoticeReplyVO> nReplyList(int num) {
		return SqlSession.selectList("noticeReplyDAO.nReplyList", num);
	}
}
