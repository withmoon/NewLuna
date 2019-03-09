package com.study.luna.pub.howtouse.serivce;

import java.util.List;

import com.study.luna.pub.command.HowToUseDTO;

public interface GetHowToUseListService {
	//전체 리스트 받아오기
	List<HowToUseDTO> getHowToUseList();
}
