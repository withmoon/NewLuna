package com.study.luna.admin.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminMailController {

   @Autowired
   private JavaMailSender mailSender;

   
    @RequestMapping(value="/adminmail.ado")
     public String mainView() {
        return "adminmail";
  }

   
    
   @RequestMapping(value = "mailSending.ado")
   public String mailSending(HttpServletRequest request) {

      String setfrom = "kmh214900@gmail.com";//보낼 관리자 gmail 계정
      String tomail = request.getParameter("tomail"); 
      String title = request.getParameter("title"); 
      String content = request.getParameter("content");

      try {
         MimeMessage message = mailSender.createMimeMessage();
         MimeMessageHelper messageHelper = new MimeMessageHelper(message,
               true, "UTF-8");

         messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
         messageHelper.setTo(tomail); // 받는사람 이메일
         messageHelper.setSubject(title); // 제목은 생략이 가능하다
         messageHelper.setText(content); // 메일 내용

         mailSender.send(message);
      } catch (Exception e) {
         System.out.println(e);
      }

      return "mailsuccess";
   }
}