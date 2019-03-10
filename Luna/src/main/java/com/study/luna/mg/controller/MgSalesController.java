package com.study.luna.mg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.service.MgPCService;
import com.study.luna.mg.util.listExcelDownload;

@Controller
public class MgSalesController {
	//�쁽�솴

	@Autowired
	private MgPCService MgPCService; 

	//�쉶�썝愿�由�
	@RequestMapping(value = "/mgSales.mdo")
	public ModelAndView mgSalesView(@RequestParam(defaultValue = "name") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {

		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
		// �젅肄붾뱶怨꾩궛      
		int count = MgPCService.countArticle(keyword);

		System.out.println("�궎�썙�뱶 :" + keyword.toString());
		System.out.println("移댁슫�듃 :" + count);
		
		int page_scale = 20;
		int block_sclae = 3;
		// �럹�씠吏� �굹�늻湲곗쿂由�
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		//�쉶�썝 寃��깋
		List<SalesVO> list = MgPCService.SalesList(start, end, keyword,searchOption);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.setViewName("body/presentCondition/mgSales");
		mv.addObject("map", map);

		System.out.println("mgsales �솕硫�");
		return mv;
	}
  

	// �삁�빟�쁽�솴
	@RequestMapping(value = "/mgReserve.mdo")
	public ModelAndView mgReserveView(@RequestParam(defaultValue = "roomnum") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
		
		String branchName = (String)session.getAttribute("branchName");
		int count = MgPCService.ReserveCount(searchOption, keyword,branchName);
		

		int page_scale = 20;
		int block_sclae = 5;
		// �럹�씠吏� �굹�늻湲곗쿂由� 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		
		List<SalesVO> list = MgPCService.mgReserveList(start, end, searchOption, keyword,branchName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);
		
		mv.addObject("map", map);
		mv.setViewName("body/presentCondition/mgReserve");

		return mv;
	}
	
	//�솚遺덊븯湲�
	@RequestMapping(value = "/mgRefund.mdo")
	public ModelAndView Reserve(@RequestParam(defaultValue = "id") String searchOption,HttpServletRequest request,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
		if(request.getParameter("id")!=null) {
			keyword = request.getParameter("id");
		}
		
	String branchName = (String)session.getAttribute("branchName");
	int count = MgPCService.RefundCount(searchOption, keyword,branchName);
	
	int page_scale = 20;
	int block_sclae = 4;
	// �럹�씠吏� �굹�늻湲곗쿂由�  
	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
	int start = boardPager.getPageBegin();
	int end = boardPager.getPageEnd();
	Date nowdate = new Date();
	System.out.println(nowdate);
	
	List<SalesVO> list = MgPCService.mgRefund(start, end, searchOption, keyword,branchName);

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	map.put("count", count);
	map.put("searchOption", searchOption);
	map.put("keyword", keyword);
	map.put("boardPager", boardPager);
	map.put("nowdate",nowdate);
	 
	mv.addObject("map", map);
	//MgPCService.mgReserve(vo);
	mv.setViewName("body/presentCondition/mgRefund");

	return mv;
	}
	
	@RequestMapping(value="Refund.mdo")   
	@ResponseBody
	public String Refund(int seq,int roomnum,String reservdate) throws InterruptedException {
		System.out.println("�솚遺덉“移�");
		
		//System.out.println(list.toString());
		//�솚遺덉“移�
		MgPCService.Refund(seq,roomnum,reservdate);
	
		return "success";
	}
	

/*	// 諛⑸Ц�쁽�솴
	@RequestMapping(value = "/mgVisit.mdo", method = RequestMethod.GET)
	public String mgVisitView() {
		return "body/presentCondition/mgVisit";
	}
*/
	
}
