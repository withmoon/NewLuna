package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.DAO.BoardDAO;
import com.study.luna.mg.model.QBoardVO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public interface MgService {
	// ���Ǳ� ��Ϻ���
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword)throws Exception;
//	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;


	// �Խñ� �󼼺���
	public QBoardVO QbaordRead(int num) throws Exception;

	//���ڵ���
	public int countArticle(String searchOption, String keyword)throws Exception;
	
	
}
