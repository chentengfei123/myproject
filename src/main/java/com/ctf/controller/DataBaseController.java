package com.ctf.controller;

import com.ctf.mapper.DataDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DataBaseController {

    @Autowired
    private DataDictMapper dataDictMapper;
    /**
     * 整合mybatis 测试
     */
    @RequestMapping("testMybatis")
    public Map<String,Object> testMybatis(){
        Map<String,Object> resultMap=new HashMap<>();
         resultMap.put("ataDict",dataDictMapper.getAll());
         return resultMap;
    }
}
