package com.study.luna.user.alamandqa.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.AlamDTO;

public interface GetAlamlistDAO {
	List<AlamDTO> getAlamlist(MemberCommand memcom);
}
