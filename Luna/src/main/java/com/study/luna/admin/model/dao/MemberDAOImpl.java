package com.study.luna.admin.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;

@Repository
public class MemberDAOImpl implements MemberDAO {
   @Autowired
   SqlSessionTemplate sqlSession;
   
   //회원목록
   @Override
   public List<MemberCommand> memberList(MemberCommand mc) {
      System.out.println("===> 회원목록");
      return sqlSession.selectList("memberDAO.memberList", mc);
   }

   
   //회원탈퇴
   @Override
   public void removedelete(String id) throws Exception {
      sqlSession.delete("luna.admin.board.removedelete",id);
      
   }

}