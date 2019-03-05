package com.study.luna.pub.member.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
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
	//마이페이지에서 정보 가져옴
	MemberCommand getMyPageInfo(MemberCommand memcom);
	//마이페이지 정보 수정
	void upUserInfo(MemberCommand memcom);
	
	//전체 지점수 가져오기
	Integer allBranchCount();
	//전체 유저수
		Integer allMemberCount();
	 //회원탈퇴
	   public void removedelete(String id)throws Exception;
	 
	 public List<String> branchList(String gugun); //고객의 소리 지점선택
	 public List<MemberCommand> memberList(int start, int end, HttpSession session); //회원정보
	 public int countMember(String id); //회원정보 갯수
	 
	 public List<MemberCommand> infoList(int start, int end, HttpSession session); //지점장목록
	 public int countinfo(String id); //지점장 갯수
	 
	 public List<MemberCommand> approveList(int start, int end, HttpSession session); //지점장 승인 목록
	 public int countApprove(String id); //지점장승인갯수
}
