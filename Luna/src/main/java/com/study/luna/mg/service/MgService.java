package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.QBoardVO;

public interface MgService {
/*	//�Խñ� �󼼺���
	public QBoardVO QbaordRead(int bno) throws Exception;
	
	//�Խñ� ����
	public void update(QBoardVO vo) throws Exception;
	*/
	
	//���Ǳ� ��Ϻ���
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;
}
