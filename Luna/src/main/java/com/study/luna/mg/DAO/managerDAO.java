package com.study.luna.mg.DAO;

import com.study.luna.mg.model.managerVO;

public interface managerDAO {
	//로그인 수 가져오기
	int login();
	//로그인수+1;
	void logincount();
	//branchname 가져오기..
	void branchname();
	
}
