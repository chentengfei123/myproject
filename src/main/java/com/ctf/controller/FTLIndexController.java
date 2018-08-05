package com.ctf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FTLIndexController {

    @RequestMapping("/ftlIndex")
    public String ftlIndex(){
        return "ftlIndex";
    }
}
