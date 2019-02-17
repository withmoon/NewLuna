package com.study.luna.mg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.managerDAO;

@Service
public class managerServiceImpl implements managerService {

	@Autowired
	private managerDAO managerDAO;

	// 로그인수 +1
	@Override
	public void logincount() {
		System.out.println("logincount+1 서비스");
		managerDAO.logincount();
	}

	// 로그인수 가져오기
	@Override
	public int login() {
		System.out.println("logincount 서비스");
		return managerDAO.login();
	}

}
