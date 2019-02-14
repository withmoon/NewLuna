package com.study.luna.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminEventBoardVO;



@Repository
public class AdminEventBoardDAOImpl implements AdminEventBoardDAO{
   
   @Inject
      SqlSession sqlsession;
   @Autowired
	SqlSessionTemplate SqlSession;
   
    @Override
      public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception {
         // TODO Auto-generated method stub
         sqlsession.insert("luna.admin.board.insertEventBoard", adminEventBoardVO);

      }


     @Override
      public List<AdminEventBoardVO> listAlls() throws Exception {
         // TODO Auto-generated method stub
         return sqlsession.selectList("luna.admin.board.listAlls");
      }


     /*user/event.jsp*/
     //진행
	@Override
	public List<AdminEventBoardVO> eventList(AdminEventBoardVO ebVO) {
		System.out.println("===> 진행이벤트 목록");
		return SqlSession.selectList("eventBoardDAO.eventList", ebVO);
	}


	@Override
	public List<AdminEventBoardVO> eventEndList(AdminEventBoardVO ebVO) {
		System.out.println("===> 마감이벤트 목록");
		return SqlSession.selectList("eventBoardDAO.eventEndList", ebVO);
	}


	@Override
	public AdminEventBoardVO read(int seq) throws Exception {
		System.out.println("===> 이벤트 상세보기");
		return SqlSession.selectOne("eventBoardDAO.viewEvent", seq);
	}

   }