package com.ctf.controller;

import com.ctf.entity.DataDict;
import com.ctf.jpa.DataDictJpa;
import com.ctf.mapper.DataDictMapper;
import com.ctf.service.ProjectDomainService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DataBaseController {

    @Autowired
    private DataDictMapper dataDictMapper;

    @Resource
    private SqlSession sqlSession;

    @Autowired
    private DataDictJpa dataDictJpa;

    @Autowired
    private ProjectDomainService projectDomainService;
    /**
     * 整合mybatis 测试
     */
    @RequestMapping("testMybatis")
    public Map<String,Object> testMybatis(){
        Map<String,Object> resultMap=new HashMap<>();
         resultMap.put("dataDict",dataDictMapper.getAll());
         return resultMap;
    }

    /**
     * myBatis接口绑定
     */
    @RequestMapping("/getById")
    public Map<String,Object> getById( int id){
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("dataDict",dataDictMapper.getById(id));
        return resultMap;
    }

    /**
     * myBatis通过SqlSession 访问
     */
    @RequestMapping("/getByDictId")
    public Map<String,Object> getByDictId(String dictId){
        Map<String,Object> resultMap=new HashMap<>();
        List<DataDict> dataDicts=sqlSession.selectList("com.ctf.mapper.DataDictMapper.getByDictId",dictId);
        resultMap.put("dataDicts",dataDicts);
        return resultMap;
    }

    /**
     * myBatis事务，批量更新、批量插入
     */
    public Map<String,Object> testTransaction(){

        return null;
    }

    /**
     * myBatis分页
     */


    /**
     * 整合jpa测试
     */
    @RequestMapping("/testJpa")
    public Map<String,Object> testJpa(){
        Map<String,Object> resultMap=new HashMap<>();
        List<DataDict> dataDicts=dataDictJpa.findAll();
        resultMap.put("dataDicts",dataDicts);
        return resultMap;
    }

    /**
     * jpa自定义
     * @param dictId
     * @return
     */
    @RequestMapping("/findAllByDictId")
    public Map<String,Object> findAllByDictId(String dictId){
        Map<String,Object> resultMap=new HashMap<>();
        List<DataDict> dataDicts=dataDictJpa.findAllByDictId(dictId);
        resultMap.put("dataDicts",dataDicts);
        return resultMap;
    }

    /**
     * jpa 分页
     */

    /**
     *
     * jpa事务、自动更新、批量更新、批量插入
     */
    @ResponseBody
    @RequestMapping(value = "/testJpaTransaction",method = RequestMethod.POST)
    public Map<String,Object> testJpaTransaction(@RequestBody DataDict dataDict){
        projectDomainService.saveDataDict(dataDict);
        return null;
    }
}
