package com.study.luna.pub.member.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;

public interface MemberService {
	//아이디 중복확인
	Integer idCheck(MemberCommand memcom);
	//회원가입
	void insertMember(MemberCommand memcom);
	//비밀번호 체크
	boolean passCheck(String id,String pass) throws Exception;
	String getBrName(String id);
	int getStatus(MemberCommand memcom);
	//로그인 상태로 변경
	void upStatus(MemberCommand memcom);
	//로그아웃 상태로 변경
	void dnStatus(MemberCommand memcom);
	//마이페이지에서 정보 가져옴
	MemberCommand getMyPageInfo(MemberCommand memcom);
	//마이페이지 정보 수정
	void upUserInfo(MemberCommand memcom);
	List<MemberCommand> memberList(MemberCommand mc);
	//전체 지점수 가져오기
	Integer allBranchCount();
	//전체 유저수
		Integer allMemberCount();
	 //회원탈퇴
	   public void removedelete(String id)throws Exception;

}
