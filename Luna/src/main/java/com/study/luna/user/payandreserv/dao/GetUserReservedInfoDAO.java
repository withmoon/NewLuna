package com.study.luna.user.payandreserv.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;

public interface GetUserReservedInfoDAO {
	List<MyPageInfoDTO> getUserReservedInfo(MemberCommand memcom);
}
