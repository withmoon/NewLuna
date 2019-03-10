package com.study.luna.admin.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminEventBoardVO;



@Repository
public class AdminEventBoardDAOImpl implements AdminEventBoardDAO{
   
   @Inject
      SqlSession sqlsession;
   @Autowired
	SqlSessionTemplate SqlSession;
   
   //진행이벤트 목록
   @Override
   public List<AdminEventBoardVO> eventAll(int start, int end) {
      	System.out.println("===> 진행이벤트 목록");
      	 
      	//BETWEEN #{start}, #{end}에 입력될 값을 맵에
      	Map<String, Object> map = new HashMap<String, Object>();
      	map.put("start", start);
      	map.put("end", end);
   		return SqlSession.selectList("eventBoardDAO.eventAll", map);
   }

   //종료이벤트목록
   @Override
   public List<AdminEventBoardVO> eventEndAll(int start, int end) {
	   System.out.println("===> 마감이벤트 목록");
     	 
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
	   return SqlSession.selectList("eventBoardDAO.eventEndAll", map);
   }
   
   //이벤트글 갯수
   @Override
   public int countEvent(String title) {
	   return SqlSession.selectOne("eventBoardDAO.countEvent", title);
   }
   @Override
   public int countEventEnd(String title) {
	   return SqlSession.selectOne("eventBoardDAO.countEventEnd", title);
   }
   
   //이벤트 글쓰기
   /*최대번호구하기*/
   public Integer eventSeq() {
		return SqlSession.selectOne("eventBoardDAO.eventSeq");
   }
   /*이벤트 글 등록*/
   public void eventwrite(AdminEventBoardVO eboardVO) {
	   SqlSession.insert("eventBoardDAO.eventwrite", eboardVO);
   }
   
   //상세보기
   @Override
   public AdminEventBoardVO read(int seq) throws Exception {
	   System.out.println("===> 이벤트 상세보기");
	   return SqlSession.selectOne("eventBoardDAO.viewEvent", seq);
   }
    
   //수정하기
   @Override
   public void update(AdminEventBoardVO eboardVO) {
	   SqlSession.update("eventBoardDAO.updateevent",eboardVO);     
   }
   public Integer event_Seq() {
	   return SqlSession.selectOne("eventBoardDAO.event_Seq");
	}

     @Override
     public void delete(int seq) throws Exception {
        sqlsession.delete("luna.admin.board.deleteevent",seq);
        
     }

	

	/*user/event.jsp*/
    

	
	
	

    
	
   }