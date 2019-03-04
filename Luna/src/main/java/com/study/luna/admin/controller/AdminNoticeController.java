package com.study.luna.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
import com.study.luna.mg.model.BoardPager;




@Controller
public class AdminNoticeController {
    
	@Autowired
	AdminNoticeBoardService adminNoticeBoardService;
	
	@RequestMapping(value="/gongji.ado", method=RequestMethod.GET)
    public String mainView() {
        return "gongji";
	}
	
	//공지사항 목록
    @RequestMapping(value = "gongjiboardList.ado", method=RequestMethod.GET)
    public @ResponseBody JSONObject  gongjiboardList(@RequestParam(defaultValue="1") int curPage,
    									AdminNoticeBoardVO noticeboardVO, HttpSession session) { 
    	//페이징 처리
    	int count = adminNoticeBoardService.countNotice(noticeboardVO.getTitle());
    			
    	int page_scale = 10; // 페이지당 게시물 수
    	int block_sclae = 5; // 화면당 페이지 수
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    	
    	//목록
    	List<AdminNoticeBoardVO> noticeList = adminNoticeBoardService.noticeAll(start, end, session);
    			
    	JSONObject obj = new JSONObject();

    	obj.put("noticeList", noticeList);
    	obj.put("noticePage", boardPager);
    	return obj;
    }
	
	@RequestMapping(value = "/gongjiupdate.ado" ,method=RequestMethod.POST)
	   public String View(@ModelAttribute AdminNoticeBoardVO vo)throws Exception{
		adminNoticeBoardService.noticeupdate(vo);  
	   return "redirect:/gongjiboardList.ado";
	   }
	
	
	 @RequestMapping(value = "/gongjiview.ado", method = RequestMethod.GET)
	   public ModelAndView view(@RequestParam int num) throws Exception {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("gongjiview");
	      mav.addObject("num",adminNoticeBoardService.noticeread(num));
	      return mav;
	   }

	
	@RequestMapping(value="/gongjiwrite.ado", method=RequestMethod.GET)
    public String View() {
        return "gongjiwrite";
}
	
    
    @RequestMapping(value = "/noticeinsert.ado" ,method=RequestMethod.GET)
    public String insert(@ModelAttribute AdminNoticeBoardVO vo) throws Exception {
    	adminNoticeBoardService.noticeinsert(vo);
       return "redirect:/gongjiboardList.ado";
    }   
    
    @RequestMapping(value = "/gongjidelete.ado" ,method=RequestMethod.GET)
    public String delete(@RequestParam int num) throws Exception {
    	adminNoticeBoardService.noticedelete(num);
       return "redirect:/gongjiboardList.ado";
    }
}