package com.study.luna.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SalesController {
    @RequestMapping(value="/sales.ado", method=RequestMethod.GET)
     public String mainView() {
        return "sales";
}
    
}