package com.study.luna.admin.controller;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;
import com.study.luna.pub.command.MemberCommand;

@Controller
public class AdminEventBoardwriteController {
	private String efilePath = "D:\\myProject\\myMain\\NewLuna\\Luna\\src\\main\\webapp\\resources\\eventimg\\";
   
   @Inject 
    AdminEventBoardService eboardService;
   
   @RequestMapping(value="/eventwrite.ado", method=RequestMethod.GET)
   public ModelAndView eventwrite() {
	   ModelAndView mav = new ModelAndView();
	   mav.setViewName("eventwrite");
	   
	   return mav;
   }
   
   //이벤트 글쓰기
   @RequestMapping(value="/eventinsert.ado", method=RequestMethod.POST)
   public String eventinsert(AdminEventBoardVO eboardVO, MultipartHttpServletRequest mpreq,
		   					HttpServletRequest req, HttpSession session) throws IllegalStateException, IOException {
	   /*MemberCommand memcom=(MemberCommand) session.getAttribute("id");
	   session.setAttribute("id", memcom.getId());*/
	   MemberCommand memcom = (MemberCommand) session.getAttribute("member");
	   
	   Integer seq = eboardService.eventSeq(); //최대 번호 가져오기
	   String filePath = efilePath + seq + "\\";
	   File file = new File(filePath);
	   if(file.exists()) {
		   if(file.isDirectory()) { //파일이 디렉토리인지 확인
			   File[] files = file.listFiles();
			   for(int i =0; i < files.length; i++) {
				   files[i].delete();
			   }
		   }
	   } else {
    	  if(!file.isDirectory()) {
    		  System.out.println("디렉토리 생성");
    		  file.mkdirs();
    	  }
	   }
      
      MultipartFile mf = mpreq.getFile("mfname");
      System.out.println("파일 추출 " + mf.getOriginalFilename());
      //저장되는 파일 이름
      String eventName = mf.getOriginalFilename();
      
      String savePath = filePath + eventName; //저장 될 파일 경로
      mf.transferTo(new File(savePath)); //파일저장
      
      eboardVO.setFiles(eventName);
      eboardVO.setImage(filePath);
      eboardVO.setTitle((String) req.getParameter("title"));
      
      String content = (String) req.getParameter("content").replace("\r\n", "<br>");
      eboardVO.setContent(content);
      eboardService.eventwrite(eboardVO);
      
	   return "redirect:/event.ado";
  }
   
   //이벤트 보기
   @RequestMapping(value = "/eventview.ado", method = RequestMethod.GET)
   public ModelAndView view(int seq, HttpSession session,MemberCommand memcom,HttpServletRequest request) throws Exception {
	   ModelAndView mav = new ModelAndView();
       mav.setViewName("eventview");
       mav.addObject("ebv", eboardService.read(seq));
       return mav;
   }
   
   //이벤트 수정
   @RequestMapping(value = "/updateevent.ado" ,method=RequestMethod.POST)
   public String updateevent(AdminEventBoardVO eboardVO, MultipartHttpServletRequest mpreq,HttpSession session, @RequestParam(value="bseq", defaultValue="1") int bseq,
		   @RequestParam(value="title") String title, @RequestParam(value="content") String content) throws IllegalStateException, IOException {
	   Integer seq = eboardService.eventSeq(); //최대 번호 가져오기
	   String filePath = efilePath + seq + "\\";
	   File file = new File(filePath);
	   if(file.exists()) {
		   if(file.isDirectory()) { //파일이 디렉토리인지 확인
			   File[] files = file.listFiles();
			   for(int i =0; i < files.length; i++) {
				   files[i].delete();
			   }
		   }
	   } else {
    	  if(!file.isDirectory()) {
    		  System.out.println("디렉토리 생성");
    		  file.mkdirs();
    	  }
	   }
      
      MultipartFile mf = mpreq.getFile("mfname");
      System.out.println("파일 추출 " + mf.getOriginalFilename());
      //저장되는 파일 이름
      String eventName = mf.getOriginalFilename();
      
      String savePath = filePath + eventName; //저장 될 파일 경로
      mf.transferTo(new File(savePath)); //파일저장
	   
	   eboardVO.setFiles(eventName);
	   eboardVO.setTitle(title);
	   eboardVO.setContent(content);
	   eboardVO.setSeq(bseq);
	   eboardService.update(eboardVO);
	   
	return "redirect:/event.ado";
   }
         
         
         @RequestMapping(value = "/deleteevent.ado")
         public String deleteView(@RequestParam int seq)throws Exception{
        	 eboardService.delete(seq);  
         return "redirect:/eventlist.ado";
         }
         
         
         
         
}