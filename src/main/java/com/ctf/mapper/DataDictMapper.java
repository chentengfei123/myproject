package com.ctf.mapper;


import com.ctf.vo.DataDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@Mapper
public interface DataDictMapper {

    @Select(" select * from ga_data_dict")
    List<DataDict> getAll();
}