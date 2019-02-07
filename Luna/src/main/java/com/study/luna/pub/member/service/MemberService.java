package com.study.luna.pub.member.service;

import com.study.luna.pub.command.MemberCommand;

public interface MemberService {
	Integer idCheck(MemberCommand memcom);
	void insertMember(MemberCommand memcom);
	boolean passCheck(String id,String pass) throws Exception;
	String getBrName(String id);
	int getStatus(MemberCommand memcom);
	void upStatus(MemberCommand memcom);
	void dnStatus(MemberCommand memcom);
	MemberCommand getMyPageInfo(MemberCommand memcom);
}
