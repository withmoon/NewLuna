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

	
	//게시글 페이징/검색
	@Override 
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword,String id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList 서비스");
		return  boardDAO.listAll(start,end, searchOption,keyword,id);
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
	public int countArticle(String searchOption, String keyword,String id)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("countArticle 레코드계산");
		return boardDAO.countArticle(searchOption, keyword,id);
	}




}
