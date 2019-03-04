package com.study.luna.pub.member.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface MemberDAO {
	public List<MemberCommand> memberList(int start, int end); //회원정보
	public int countMember(String id); //회원정보 갯수

   void removedelete(String id) throws Exception;
}