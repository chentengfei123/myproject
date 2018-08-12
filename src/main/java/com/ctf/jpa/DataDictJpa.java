package com.ctf.jpa;

import com.ctf.entity.DataDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public interface DataDictJpa extends JpaRepository<DataDict,Long>,JpaSpecificationExecutor<DataDict>,Serializable {

    List<DataDict> findAllByDictId(String dictId);

    @Modifying
    @Transactional
    @Query("update DataDict as dd set dd.dictId = 2 where dd.keyId =  ?1")
    int updateByKeyId(int keyId);
}
