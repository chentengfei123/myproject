package com.ctf.controller;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MembercCntroller {

    @Value("${version}")
    private String version;

    @RequestMapping(value = "/memberIndex",method = RequestMethod.POST)
    public String memberIndex(){
        return version;
    }

}
