package com.study.luna.admin.controller;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.admin.board.service.AdminManagerApproveService;
import com.study.luna.admin.model.vo.AdminManagerApproveVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;



@Controller
public class ApproveController {
	
	@Inject
	AdminManagerApproveService adminManagerApproveService;
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/approve.ado", method=RequestMethod.GET)
	   public String mainView(HttpSession session,MemberCommand memcom) {
		 memcom = (MemberCommand) session.getAttribute("member");
	    	
	   		if(memcom.getPosition().equals("총관리자")|memcom.getPosition().equals("관리자")){
	   			memcom = (MemberCommand) session.getAttribute("member");
	   			session.setAttribute("member", memcom);
		        return "approve";
	   		}
	   		return "cannotAccess";
	}
	
	//지점장 승인 목록
	@RequestMapping(value = "/approveList.ado", method=RequestMethod.GET)
	public @ResponseBody JSONObject approveListView(@RequestParam(defaultValue="1") int curPage,
							MemberCommand memberCommand, HttpSession session){
		//페이징 처리
		int count = memberService.countApprove(memberCommand.getId());
		   			
		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		   	
		List<MemberCommand> approveList = memberService.approveList(start, end, session);
		
		JSONObject obj = new JSONObject();

	   	obj.put("approveList", approveList);
	   	obj.put("approvePage", boardPager);
	   	return obj;
	 }
	
	
	@RequestMapping(value="/approvedelete.ado")
	public String approvedelete(@RequestParam("id")String id , @RequestParam("type")String type,HttpSession session,MemberCommand memcom)throws Exception{
		 memcom = (MemberCommand) session.getAttribute("member");
	    	
	   		if(memcom.getPosition().equals("총관리자")|memcom.getPosition().equals("관리자")){
	   			memcom = (MemberCommand) session.getAttribute("member");
	   			session.setAttribute("member", memcom);
	   			adminManagerApproveService.approvedelete(id);
	   			return "redirect:/"+type+".ado";
	   		}
	   			return "cannotAccess";
	}
}
