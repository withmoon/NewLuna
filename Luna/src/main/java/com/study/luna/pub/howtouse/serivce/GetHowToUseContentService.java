package com.study.luna.pub.howtouse.serivce;

import java.util.List;

import com.study.luna.pub.command.HowToUseDTO;

public interface GetHowToUseContentService {
	List<HowToUseDTO> getHowToUseContent(int num);
}
