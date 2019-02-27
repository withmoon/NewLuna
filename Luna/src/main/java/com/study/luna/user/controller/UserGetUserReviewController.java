package com.study.luna.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.review.service.RoomReviewService;

@Controller
public class UserGetUserReviewController {
	@Autowired
	RoomReviewService rrser;
	//인선트 한담에 룸넘만 반환해 주면 data에서 얘 룸넘을 찾아서 환불이면 환불이랑 영수증만 표시 환불아니면 영수증만 표시
	@RequestMapping(value="/getUserReview.udo",method = RequestMethod.GET)
	public @ResponseBody List<String> getUserReview(MemberCommand memcom,HttpSession session){

		//아이디 세팅
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		//사용자가 리뷰 달은 방 번호 가져오기
		List<String> userReviewList=rrser.getUserReview(memcom.getId());
		
		return userReviewList;
	}
}