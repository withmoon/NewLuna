package com.study.luna.pub.member.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO {
   @Autowired
   SqlSessionTemplate sqlSession;
   
   //회원갯수
   @Override
   public List<MemberCommand> memberList(int start, int end) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
    	
	   return sqlSession.selectList("memberDAO.memberList", map);
   }

   //회원정보 갯수
   @Override
   public int countMember(String id) {
	   return sqlSession.selectOne("memberDAO.countMember", id);
   }

   //지점장 목록
   @Override
   public List<MemberCommand> infoList(int start, int end) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
   
	   return sqlSession.selectList("memberDAO.infoList", map);
   }

   //지점장 갯수
   @Override
	public int countinfo(String id) {
		return sqlSession.selectOne("memberDAO.countinfo", id);
	}

   //지점장승인
   @Override
   public List<MemberCommand> approveList(int start, int end) {
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
   
	   return sqlSession.selectList("memberDAO.approveList", map);
   }

   //지점장승인 갯수
   @Override
   public int countApprove(String id) {
		return sqlSession.selectOne("memberDAO.countApprove", id);
   }
}