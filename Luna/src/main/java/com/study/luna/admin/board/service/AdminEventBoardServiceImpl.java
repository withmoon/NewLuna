package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminEventBoardDAO;
import com.study.luna.admin.model.dao.AdminEventBoardDAOImpl;
import com.study.luna.admin.model.vo.AdminEventBoardVO;

@Service
public class AdminEventBoardServiceImpl implements AdminEventBoardService{
   
   @Inject
   AdminEventBoardDAO adminEventBoardDAO;
   @Autowired
   AdminEventBoardDAOImpl eventBoardImpl;
   
   @Override
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception{
      adminEventBoardDAO.insert(adminEventBoardVO);
   }

   
    @Override
    public List<AdminEventBoardVO> listAlls() throws Exception{
       return adminEventBoardDAO.listAlls();
    }


    /*user/event.jsp*/
    //진행
	@Override
	public List<AdminEventBoardVO> eventList(AdminEventBoardVO ebVO) {
		return eventBoardImpl.eventList(ebVO);
	}

	//마감
	@Override
	public List<AdminEventBoardVO> eventEndList(AdminEventBoardVO ebVO) {
		return eventBoardImpl.eventEndList(ebVO);
	}

	//이벤트 상세보기
	@Override
	public AdminEventBoardVO read(int seq) throws Exception {
		return eventBoardImpl.read(seq);
	}
}