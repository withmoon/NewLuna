package com.study.luna.admin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Controller
public class AdminQnABoardWriteController {

   @Inject
   AdminQnABoardService adminQnABoardService;

   @RequestMapping(value = "/insert.ado", method = RequestMethod.POST)
   public String insert(@ModelAttribute AdminQnABoardVO adminQnABoardVO) throws Exception {

      adminQnABoardService.insert(adminQnABoardVO);
      return "boardList";
   }

   @RequestMapping(value = "/write.ado", method = RequestMethod.GET)
   public String mainView() {
      return "write";
   }

}