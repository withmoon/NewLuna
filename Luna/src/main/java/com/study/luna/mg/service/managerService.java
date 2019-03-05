package com.study.luna.mg.service;

import javax.servlet.http.HttpSession;

public interface managerService {

	//로그인수 +1 
	public void logincount();
	//branchname 구하기...
	String branchname(String id);
	//로그인 수 가져오기
	int login();
	//예약수 가져오기
	int roomcount(HttpSession session,String days);
	//회원가입 수 
	public int join();
	//회원수 
	public int member();

	
}
