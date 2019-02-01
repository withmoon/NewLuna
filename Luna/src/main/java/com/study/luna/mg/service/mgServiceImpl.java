package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.BoardDAO;
import com.study.luna.mg.model.QBoardVO;

@Service
public class mgServiceImpl  implements MgService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList 서비스 리턴");
		return boardDAO.QboardList(vo);
	}

	@Override
	public QBoardVO QbaordRead(String title) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardRead 서비스");
		return boardDAO.QbaordRead(title);
	}



}
