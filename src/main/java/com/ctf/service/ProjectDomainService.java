package com.ctf.service;

import com.ctf.entity.DataDict;
import com.ctf.jpa.DataDictJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("projectDomainService")
public class ProjectDomainService {

    @Autowired
    private DataDictJpa dataDictJpa;


    @Transactional
    public void saveDataDict(DataDict dataDict){
        dataDictJpa.save(dataDict);
        int i=1/0;
        System.out.println("#######=");
    }
}
