package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.QBoardVO;

public interface MgService {
	/*
	 * 
	 * //�Խñ� ���� public void update(QBoardVO vo) throws Exception;
	 */

	// �Խñ� �󼼺���
	public QBoardVO QbaordRead(String title) throws Exception;

	// ���Ǳ� ��Ϻ���
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;
}
