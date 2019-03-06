package com.study.luna.user.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.comment.vo.NoticeReplyVO;


@Repository
public class NoticeReplyDAOImpl implements NoticeReplyDAO {
	@Autowired
	SqlSessionTemplate SqlSession;
	
	//답글 목록
	public List<NoticeReplyVO> nReplyList(int num, int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
     	map.put("start", start);
     	map.put("end", end);
     	
		return SqlSession.selectList("noticeReplyDAO.nReplyList", map);
	}
	
	//답글 갯수
	@Override
	public int countnReply(int num) {
		return SqlSession.selectOne("noticeReplyDAO.countnReply", num);
	}

	//답글 입력
	public void create(NoticeReplyVO nReplyVO) {
		SqlSession.insert("noticeReplyDAO.nReplyInsert", nReplyVO);
	}
}
