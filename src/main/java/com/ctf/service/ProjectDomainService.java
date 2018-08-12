package com.ctf.service;

import com.ctf.entity.DataDict;
import com.ctf.jpa.DataDictJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("projectDomainService")
public class ProjectDomainService {

    @Autowired
    private DataDictJpa dataDictJpa;


    @Transactional
    public void saveDataDict(DataDict dataDict){
        dataDictJpa.save(dataDict);
//        int i=1/0;
        System.out.println("#######=");
    }
    public List<DataDict> byJpaPageAndSort(){
        DataDict dataDict=new DataDict();
        dataDict.setDictId("tradeType"); // 查询条件
         // 创建查询参数
        Example example=Example.of(dataDict);
        // 获取排序对象
        Sort sort=new Sort(Sort.Direction.DESC,"dictItemId");
        // 创建分页对象
        PageRequest pageRequest = new PageRequest(1,3,sort);
        // 分页查询
        return (List<DataDict>)dataDictJpa.findAll(example,pageRequest).getContent();
    }
}
