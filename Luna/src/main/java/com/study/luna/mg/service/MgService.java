package com.study.luna.mg.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.mg.model.QBoardVO;
 
public interface MgService {
	//mgQBoard
	 
	// 문의글 목록보기
	public List<QBoardVO> QboardList(int start, int end, String searchOption, String keyword, String branchName)throws Exception;
	//admin 문의목록
	public List<QBoardVO> inquireList(int start, int end,String searchOption, String keyword, HttpSession session); 
	//문의 갯수
	public int countInqure(String searchOption, String keyword); 
	// 게시글 상세보기
	public QBoardVO QbaordRead(QBoardVO vo) throws Exception;

	//레코드계산
	public int countArticle(String searchOption,String keyword,String branchName)throws Exception;

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
	
	//admin
	public void inquireinsert(QBoardVO vo)throws Exception;
	public QBoardVO inquireread(Integer seq)throws Exception;
	public void inquiredelete(Integer seq)throws Exception;
}
