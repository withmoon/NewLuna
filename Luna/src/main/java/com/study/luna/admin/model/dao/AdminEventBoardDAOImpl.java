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

     @Override
     public AdminEventBoardVO read1(int seq) throws Exception {
        return  sqlsession.selectOne("luna.admin.board.readevent",seq);

     }

     @Override
     public void update(AdminEventBoardVO adminEventBoardVO) throws Exception {
        sqlsession.update("luna.admin.board.updateevent",adminEventBoardVO);
        
     }

     @Override
     public void delete(int seq) throws Exception {
        sqlsession.delete("luna.admin.board.deleteevent",seq);
        
     }

     
     
     
     
     

     /*user/event.jsp*/
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
	public int count(ModelAndView mav) {
		return SqlSession.selectOne("eventBoardDAO.count", mav);
	}

    //상세보기
	@Override
	public AdminEventBoardVO read(int seq) throws Exception {
		System.out.println("===> 이벤트 상세보기");
		return SqlSession.selectOne("eventBoardDAO.viewEvent", seq);
	}
   }