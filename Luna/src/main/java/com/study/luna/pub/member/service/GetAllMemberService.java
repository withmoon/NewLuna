package com.study.luna.pub.member.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface GetAllMemberService {
	List<MemberCommand> getAllMember(int start,int end,String searchOption,String keyword);
}
