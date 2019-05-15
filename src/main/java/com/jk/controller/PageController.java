package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toindex")
    public String toindex(){
        return "index";
    }
    @RequestMapping("tomian")
    public String tomain(){
        return "main";
    }




}
