package com.study.luna.pub.member.service.Impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.Impl.AllBranchCountDAOImpl;
import com.study.luna.pub.member.dao.Impl.AllMemberCountDAOImpl;
import com.study.luna.pub.member.dao.Impl.CancleExpulmemberDAOImpl;
import com.study.luna.pub.member.dao.Impl.DeleteAdminDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetAdminListDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetBrNameDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetBranchNameDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetMyPageInfoDAOImpl;
import com.study.luna.pub.member.dao.Impl.GetStatusDAOImpl;
import com.study.luna.pub.member.dao.Impl.IdCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.InsertAdminDAOImpl;
import com.study.luna.pub.member.dao.Impl.InsertMemberDAOImpl;
import com.study.luna.pub.member.dao.Impl.MemberDAOImpl;
import com.study.luna.pub.member.dao.Impl.MemberExpluDAOImpl;
import com.study.luna.pub.member.dao.Impl.PassCheckDAOImpl;
import com.study.luna.pub.member.dao.Impl.UpUserInfoDAOImpl;
import com.study.luna.pub.member.dao.Impl.UpdateAdminDAOImpl;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.SHA256;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	IdCheckDAOImpl idchkDAOImpl;
	@Autowired
	InsertMemberDAOImpl instMemberDAOImpl;
	@Autowired
	PassCheckDAOImpl pcDAOimpl;
	@Autowired
	GetBrNameDAOImpl getbrDAOImpl;
	@Autowired
	GetStatusDAOImpl getStDAOImpl;
	@Autowired
	GetMyPageInfoDAOImpl getMyInfoDAOImpl;
	@Autowired
	UpUserInfoDAOImpl upUsInfDAOImpl;
	@Autowired
	MemberDAOImpl memberDAOImpl;
	@Autowired
	AllBranchCountDAOImpl abcDAOImpl;
	@Autowired
	AllMemberCountDAOImpl amcDAOImpl;
	@Autowired
	GetBranchNameDAOImpl branchnameDAOImpl; //고객의 소리 지점 선택
	@Autowired
	MemberExpluDAOImpl mepDAOImpl;
	@Autowired
	CancleExpulmemberDAOImpl cepmDAOImpl;
	@Autowired
	GetAdminListDAOImpl galDAOImpl;
	@Autowired
	InsertAdminDAOImpl iaDAOImpl;
	@Autowired
	UpdateAdminDAOImpl uaDAOImpl;
	@Autowired
	DeleteAdminDAOImpl daDAOImpl;
	
	@Override
	public Integer idCheck(MemberCommand memcom) {		
		return idchkDAOImpl.idCheck(memcom);
	}

	@Override
	public void insertMember(MemberCommand memcom) {
		instMemberDAOImpl.insertMember(memcom);
	}

	@Override
	public boolean passCheck(String id,String pass) throws Exception {
		String realpass=pcDAOimpl.getPass(id);
		
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(pass.getBytes());
		
		boolean result=realpass.equals(shaPass)? true :false;
		
		return result;
	}

	@Override
	public String getBrName(String id) {
		return getbrDAOImpl.getBrName(id);
	}

	@Override
	public int getStatus(MemberCommand memcom) {
		return getStDAOImpl.getStatus(memcom);
	}
	@Override
	public MemberCommand getMyPageInfo(MemberCommand memcom) {
		return getMyInfoDAOImpl.getMyPageInfo(memcom);
	}

	@Override
	public void upUserInfo(MemberCommand memcom) {
		upUsInfDAOImpl.upUserInfo(memcom);
	}

	/*@Override
	public List<MemberCommand> memberList(MemberCommand mc) {
		return memberDAOImpl.memberList(mc);
	}*/

	@Override
	public Integer allBranchCount() {
		return abcDAOImpl.allBranchCount();
	}
	@Override
	public Integer allMemberCount() {
		return amcDAOImpl.allMemberCount();
	}
	 
	//고객의 소리 지점 선택
	@Override
	public List<String> branchList(String gugun) {
		return branchnameDAOImpl.branchList(gugun);
	}

	//회원정보
	@Override
	public List<MemberCommand> memberList(int start, int end, HttpSession session) {
		return memberDAOImpl.memberList(start, end);
	}

	//회원정보 갯수
	@Override
	public int countMember(String id) {
		return memberDAOImpl.countMember(id);
	}

	//지점장 목록
	@Override
	public List<MemberCommand> infoList(int start, int end, HttpSession session) {
		return memberDAOImpl.infoList(start, end);
	}

	//지점장 갯수
	@Override
	public int countinfo(String id) {
		return memberDAOImpl.countinfo(id);
	}

	//지점장 승인
	@Override
	public List<MemberCommand> approveList(int start, int end, HttpSession session) {
		return memberDAOImpl.approveList(start, end);
	}

	//지점장 승인 갯수
	@Override
	public int countApprove(String id) {
		return memberDAOImpl.countApprove(id);
	}
	@Override
	public void expulmember(String id) {
		mepDAOImpl.expulmember(id);
	}
	@Override
	public void cancleExpulmember(String id) {
		cepmDAOImpl.cancleExpulmember(id);
	}

	@Override
	public List<MemberCommand> getAdminList() {
		return galDAOImpl.getAdminList();
	}

	@Override
	public void insertAdmin(MemberCommand memcom) {
		iaDAOImpl.insertAdmin(memcom);
	}

	@Override
	public void updateAdmin(MemberCommand memcom) {
		uaDAOImpl.updateAdmin(memcom);
	}

	@Override
	public void deleteAdmin(String id) {
		daDAOImpl.deleteAdmin(id);
	} 


}
