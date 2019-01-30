package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.QBoardVO;

public interface MgService {
/*	//게시글 상세보기
	public QBoardVO QbaordRead(int bno) throws Exception;
	
	//게시글 수정
	public void update(QBoardVO vo) throws Exception;
	*/
	
	//문의글 목록보기
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;
}
