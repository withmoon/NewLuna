package com.study.luna.user.alamandqa.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.AlamDTO;

public interface AlamService {
	//문의를 제외한 나머지 알림 가져옴
	List<AlamDTO> getAlamlist(MemberCommand memcom);
	//알림 읽음 표시 
	void readAlam(AlamDTO ald);
}
