package com.study.luna.mg.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.BoardDAO;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.user.qna.dao.Impl.DeleteUserQnaDAOImpl;
import com.study.luna.user.qna.dao.Impl.GetUserQnAllDAOImpl;
import com.study.luna.user.qna.dao.Impl.GetUserQnCountDAOImpl;
import com.study.luna.user.qna.dao.Impl.UpUserQnaContentDAOImpl;
import com.study.luna.user.qna.dao.Impl.UpUserQnaReadstDAOImpl;
 
@Service
public class mgServiceImpl  implements MgService{
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	GetUserQnCountDAOImpl guqcDAOImpl;
	@Autowired
	GetUserQnAllDAOImpl guqaDAOImpl;
	@Autowired
	DeleteUserQnaDAOImpl duqDAOImpl;
	@Autowired
	UpUserQnaContentDAOImpl uuqDAOImpl;
	@Autowired
	UpUserQnaReadstDAOImpl uuqrDAOImpl;
	
	//게시글 페이징/검색
	@Override 
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword,String branchName) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList 서비스");
		return  boardDAO.listAll(start,end, searchOption,keyword,branchName);
	}
/*	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList ���� ����");
		return boardDAO.QboardList(vo); 
	}
*/
	//게시글 상세보기
	@Override
	public QBoardVO QbaordRead(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardRead 서비스");
		return boardDAO.QbaordRead(vo);
	}
	//레코드계산
	@Override
	public int countArticle(String searchOption, String keyword,String branchName)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("countArticle 레코드계산");
		return boardDAO.countArticle(searchOption, keyword,branchName);
	}
	//메일보내기체크
	@Override
	public int mailstatus(QBoardVO vo) { 
		System.out.println("mailstatus 서비스"); 
		return boardDAO.mailstatus(vo);
	}
	@Override
	public Integer getUserQnCount(String id) {
		return guqcDAOImpl.getUserQnCount(id);
	}
	@Override
	public List<QBoardVO> getUserQnAll(int start,int end,String id) {
		return guqaDAOImpl.getUserQnAll(start,end,id);
	}


	//고객의 소리 insert
	@Override
	public void create(QBoardVO vo) {
		boardDAO.create(vo);
	}
	@Override
	public void deleteUserQna(int seq) {
		duqDAOImpl.deleteUserQna(seq);
		
	}
	@Override
	public void upUserQnaContent(int seq, String content) {
		uuqDAOImpl.upUserQnaContent(seq, content);
		
	}
	@Override
	public void upUserQnaReadst(int seq) {
		uuqrDAOImpl.upUserQnaReadst(seq);
	}
	
	//admin 문의목록
	@Override
	public List<QBoardVO> inquireList(int start, int end, HttpSession session) {
		return boardDAO.inquireList(start, end);
	}
	
	//admin 문의갯수
	@Override
	public int countInqure(String title) {
		return boardDAO.countInqure(title);
	}
	
	//admin
	@Override
	public void inquireinsert(QBoardVO vo) throws Exception {
		boardDAO.inquireinsert(vo);
		
	}
	@Override
	public QBoardVO inquireread(Integer seq) throws Exception {
		return boardDAO.inquireread(seq);
	}
	@Override
	public void inquiredelete(Integer seq) throws Exception {
		boardDAO.inquiredelete(seq);
	}
	
}
