package com.study.luna.pub.member.dao;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface MemberDAO { 
	//회원정보
	public List<MemberCommand> memberList(int start, int end); 
	//회원정보 갯수
	public int countMember(String id); 
	 //지점장목록
	public List<MemberCommand> infoList(int start, int end);
	//지점장 갯수
	public int countinfo(String id); 
	//지점장 승인 목록
	public List<MemberCommand> approveList(int start, int end); 
	//지점장승인갯수
	public int countApprove(String id); 
	 //전체 회원 검색용
	List<MemberCommand> getAllMember(int start,int end,String searchOption,String keyword);
	//전체 회원 검색용 카운트
	Integer getAllMemberCount(String searchOption,String keyword);
	//아이디의 포지션 가져오기
	MemberCommand getMemberPosition(String id);
	//제명처리로 인한 환불
	void refundofexpul(String id);
	//아이디 찾기
	String findId(MemberCommand memcom);
	//비번 찾기
	String findpw(MemberCommand memcom);
	//비번 바꾸기
	void changePW(MemberCommand memcom);
}