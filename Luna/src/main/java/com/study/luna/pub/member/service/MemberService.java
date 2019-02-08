package com.study.luna.pub.member.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.board.vo.EventBoardVO;

public interface MemberService {
	Integer idCheck(MemberCommand memcom);
	void insertMember(MemberCommand memcom);
	boolean passCheck(String id,String pass) throws Exception;
	String getBrName(String id);
	int getStatus(MemberCommand memcom);
	void upStatus(MemberCommand memcom);
	void dnStatus(MemberCommand memcom);
	MemberCommand getMyPageInfo(MemberCommand memcom);
	void upUserInfo(MemberCommand memcom);
	List<MemberCommand> memberList(MemberCommand mc);
}
