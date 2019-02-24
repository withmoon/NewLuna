package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;

@Repository
public class BoardDAOImpl  implements BoardDAO{

	@Autowired
	private SqlSessionTemplate SqlSession;

	@Override
	public void insertBoard(QBoardVO vo) {
		// TODO Auto-generated method stub
		
	}
	//문의게시판 전체목록
	@Override
	public List<QBoardVO> listAll(int start, int end, String searchOption, String keyword) {
		// TODO Auto-generated method stub
		//검색옵션 , 키워드 맵에 저장
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return SqlSession.selectList("mgQBoard.listAll",map);
	}
	/*public List<QBoardVO> QboardList(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList DAO ����ó�� ");
		return SqlSession.selectList("managerDAO.QList",vo);
	}*/

	//상세보기
	@Override
	public QBoardVO QbaordRead(int num) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QbaordRead DAO");
		return SqlSession.selectOne("mgQBoard.QRead",num); 
	}
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return SqlSession.selectOne("mgQBoard.countArticle", map);
	}



}
