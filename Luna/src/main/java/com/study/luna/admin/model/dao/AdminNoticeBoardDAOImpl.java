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

import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

@Repository
public class AdminNoticeBoardDAOImpl implements AdminNoticeBoardDAO {

	@Inject
	SqlSession sqlsession;
	@Autowired
	SqlSessionTemplate SqlSession;

	@Override
	public void noticeinsert(AdminNoticeBoardVO vo) throws Exception {
		sqlsession.insert("luna.admin.board.noticeinsert", vo);
	}

	@Override
	public List<AdminNoticeBoardVO> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList("luna.admin.board.noticeList");
	}

	@Override
	public void noticeupdate(AdminNoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update("luna.admin.board.noticeupdate",vo);
		
	}

	@Override
	public AdminNoticeBoardVO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("luna.admin.board.noticeread",num);
	}

	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.delete("luna.admin.board.noticedelete",num);
	}

	/*user_inform*/
	//공지사항 목록
	public List<AdminNoticeBoardVO> noticeAll(int start, int end) {
		System.out.println("===> 공지사항 목록");
		
		Map<String, Object> map = new HashMap<String, Object>();
     	map.put("start", start);
     	map.put("end", end);
    
		return SqlSession.selectList("noticeBoardDAO.noticeAll", map);
	}

	//글 갯수
	public int countNotice(String title) {
		return SqlSession.selectOne("noticeBoardDAO.countNotice", title);
	}

	//공지사항 상세보기
	public AdminNoticeBoardVO read(int num) {
		System.out.println("===> 공지사항 상세보기");
		return SqlSession.selectOne("noticeBoardDAO.viewNotice", num);
	}
}
