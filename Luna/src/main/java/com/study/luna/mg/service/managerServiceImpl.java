package com.study.luna.mg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.managerDAO;

@Service
public class managerServiceImpl implements managerService {

	@Autowired
	private managerDAO managerDAO;

	// �α��μ� +1
	@Override
	public void logincount() {
		System.out.println("logincount+1 ����");
		managerDAO.logincount();
	}

	// �α��μ� ��������
	@Override
	public int login() {
		System.out.println("logincount ����");
		return managerDAO.login();
	}

}
