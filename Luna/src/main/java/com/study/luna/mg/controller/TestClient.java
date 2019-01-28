package com.study.luna.mg.controller;
import java.util.List;

import com.study.luna.mg.DAO.testDAO;
import com.study.luna.mg.model.testVO;

public class TestClient {
	public static void main(String[] args) {
		testDAO testDAO = new testDAO();
		testVO vo = new testVO();
		
		vo.setName("ÃP±æµ¿");
		vo.setAge(12);
		
		System.out.println(vo);
		
		List<testVO> testList = testDAO.selectTest(vo);
		for(testVO test : testList) {
			System.out.println("test :" + test.toString());
		}
	}
}
