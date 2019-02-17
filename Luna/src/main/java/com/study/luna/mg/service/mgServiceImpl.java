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

	
	//�Խñ� ����¡/�˻�
	@Override
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList ����");
		return  boardDAO.listAll(start,end, searchOption,keyword);
	}
/*	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList ���� ����");
		return boardDAO.QboardList(vo); 
	}
*/
	//�Խñ� �󼼺���
	@Override
	public QBoardVO QbaordRead(int num) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardRead ����");
		return boardDAO.QbaordRead(num);
	}
	//���ڵ���
	@Override
	public int countArticle(String searchOption, String keyword)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("countArticle ���ڵ���");
		return boardDAO.countArticle(searchOption, keyword);
	}




}
