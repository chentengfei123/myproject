package com.ctf.vo;

import lombok.Data;

import java.util.Date;

@Data
public class DataDict {

    private Integer keyId;
    private String dictId;
    private String dictName;
    private String dictItemId;
    private String dictItemName;
    private String deleteFlg;
    private Date createTime;
    private Date updateTime;
    private String createrId;
    private String updaterId;
}
