package com.study.luna.mg.DAO;

public interface managerDAO {
	//로그인 수 가져오기
	int login();
	//로그인수+1;
	void logincount();
	//branchname 가져오기..
	String branchname(String id);
	
}
