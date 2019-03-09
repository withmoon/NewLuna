package com.study.luna.pub.howtouse.dao;

import java.util.List;

import com.study.luna.pub.command.HowToUseDTO;

public interface HowToUseDAO {
	//글쓰기
	void insertHowToUse(HowToUseDTO htu);
	//전체 리스트 받아오기
	List<HowToUseDTO> getHowToUseList();
	//num 최대 번호
	Integer getHowToUseMaxNum();
	//cnum 최대 번호
	Integer getHowToUseMaxCnum();
	//글 받아오기
	HowToUseDTO getHowToUseContent(int num);
}
