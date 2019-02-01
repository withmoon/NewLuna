package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;

public interface BoardDAO {
	
	public void insertBoard(QBoardVO vo);

	//�Խñ� ���
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;
	
	//�Խñ� �󼼺���
	public QBoardVO QbaordRead(String  title) throws Exception;
		
	}

