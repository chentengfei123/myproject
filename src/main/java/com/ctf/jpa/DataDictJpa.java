package com.ctf.jpa;

import com.ctf.entity.DataDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface DataDictJpa extends JpaRepository<DataDict,Long>,JpaSpecificationExecutor<DataDict>,Serializable {

    List<DataDict> findAllByDictId(String dictId);
}
