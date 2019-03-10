package com.study.luna.mg.DAO;

import java.util.List; 
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;

public interface BoardDAO {
	
	public void insertBoard(QBoardVO vo);
 
	//게시글 목록
	public List<QBoardVO> listAll(int start, int end, String searchOption, String keyword, String branchName);
	 
	public List<QBoardVO> inquireList(int start, int end,String searchOption, String keyword); //admin 문의목록
	public int countInqure(String searchOption, String keyword); //문의 갯수
	
	//게시글 상세보기
	public QBoardVO QbaordRead(QBoardVO vo) throws Exception;

	//레코드 계싼
	public int countArticle(String searchOption, String keyword,String branchName) throws Exception;
	
	//메일체크
	public int mailstatus(QBoardVO vo);
	
	public void create(QBoardVO vo); //user.고객의 소리 보내기
	
	//admin
		public void inquireinsert(QBoardVO vo)throws Exception;
		public QBoardVO inquireread(Integer seq)throws Exception;
		public void inquiredelete(Integer seq)throws Exception;
	}

