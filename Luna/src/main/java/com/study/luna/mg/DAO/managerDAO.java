package com.study.luna.mg.DAO;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.StatisticsVO;

public interface managerDAO {
	//로그인 수 가져오기
	int login(); 
	//로그인수+1;
	void logincount(); 
	//branchname 가져오기..
	String branchname(String id);
	//예약수 가져오기
	int roomcount(HttpSession session, String days);
	//회원가입수 가져오기
	int join();
	//회원수 가져오기
	int member();
	//환불수 가져오기
	int reroom();
	
	//고객의소리 미리보기 가져오기
	List<QBoardVO> board();
	//차트
	List<StatisticsVO> chart();
	
}
