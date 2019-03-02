package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.DAO.BoardDAO;
import com.study.luna.mg.model.QBoardVO;
import com.sun.org.apache.bcel.internal.generic.RETURN;

public interface MgService {
	//mgQBoard
	
	// 문의글 목록보기
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword, String branchName)throws Exception;
//	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception;


	// 게시글 상세보기
	public QBoardVO QbaordRead(QBoardVO vo) throws Exception;

	//레코드계산
	public int countArticle(String searchOption, String keyword, String branchName)throws Exception;

	//메일보내기 체크
	public int mailstatus(QBoardVO vo);
	//사용자 문의 갯수 가져오기
	Integer getUserQnCount(String id);
	
	//사용자 문의 글 가져오기
	List<QBoardVO> getUserQnAll(int start,int end,String id);
	
	public void create(QBoardVO vo); //user.고객의 소리 insert
	
	//seq에 해당하는 문의 글 삭제
	void deleteUserQna(int seq);
	//seq에 해당하는 content,update
	void upUserQnaContent(int seq,String content);
	//내용 읽음 처리
	void upUserQnaReadst(int seq);
}
