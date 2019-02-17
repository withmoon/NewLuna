package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.DAO.BoardDAO;
import com.study.luna.mg.model.QBoardVO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public interface MgService {
	// 문의글 목록보기
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword)throws Exception;
//	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;


	// 게시글 상세보기
	public QBoardVO QbaordRead(int num) throws Exception;

	//레코드계산
	public int countArticle(String searchOption, String keyword)throws Exception;
	
	
}
