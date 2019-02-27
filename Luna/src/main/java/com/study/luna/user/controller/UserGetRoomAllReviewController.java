package com.study.luna.user.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.service.RoomReviewService;

@Controller
public class UserGetRoomAllReviewController {
	@Autowired
	RoomReviewService rrser;

	@RequestMapping(value="/getRoomAllReview.udo",method = RequestMethod.GET)
	public @ResponseBody JSONObject getSidoGugung(@RequestParam("curpage")int curPage,@RequestParam("roomnum")int roomnum){
		
		int count = rrser.getReviewCount(roomnum);
		
		int page_scale = 20;
		int block_sclae = 10;
		// 페이지 나누기처리 
		BoardPager reviewPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = reviewPager.getPageBegin();
		int end = reviewPager.getPageEnd();

		
		List<RoomReviewDTO> allreviewlist=rrser.getRoomAllReview(start,end,roomnum);
		String reviewscore=rrser.getReviewStarAvg(roomnum);
		
		JSONObject obj = new JSONObject();
		obj.put("rvlist", allreviewlist);
		obj.put("rvpager", reviewPager);
		obj.put("rvscore", reviewscore);
		return obj;
	}
}
