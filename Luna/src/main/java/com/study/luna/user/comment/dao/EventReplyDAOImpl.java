package com.study.luna.user.comment.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.comment.vo.EventReplyVO;

@Repository
public class EventReplyDAOImpl implements EventReplyDAO {
	@Autowired
	SqlSessionTemplate SqlSession;
	
	//답글 목록
	public List<EventReplyVO> eReplyList(int seq, int start, int end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq", seq);
     	map.put("start", start);
     	map.put("end", end);
     	
		return SqlSession.selectList("eventReplyDAO.eReplyList", map);
	}

	//답글 갯수
	public int counteReply(int num) {
		return  SqlSession.selectOne("eventReplyDAO.counteReply", num);
	}

	//답글 입력
	@Override
	public void create(EventReplyVO eReplyVO) {
		SqlSession.insert("eventReplyDAO.eReplyInsert", eReplyVO);
	}
	
	//댓글 수정
	public void eReplyUp(EventReplyVO eReplyVO) {
		SqlSession.update("eventReplyDAO.eReplyUpdate", eReplyVO);
	}

	//댓글삭제
	public void eReplyDe(EventReplyVO eReplyVO) {
		SqlSession.delete("eventReplyDAO.eReplyDelete", eReplyVO);
	}
}
