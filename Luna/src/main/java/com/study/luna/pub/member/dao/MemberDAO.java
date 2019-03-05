package com.study.luna.pub.member.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface MemberDAO {
	public List<MemberCommand> memberList(int start, int end); //회원정보
	public int countMember(String id); //회원정보 갯수
	
	public List<MemberCommand> infoList(int start, int end); //지점장목록
	public int countinfo(String id); //지점장 갯수
	
	public List<MemberCommand> approveList(int start, int end); //지점장 승인 목록
	public int countApprove(String id); //지점장승인갯수

   void removedelete(String id) throws Exception;
}