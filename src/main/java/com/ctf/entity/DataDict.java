package com.ctf.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ga_data_dict")
public class DataDict {

    @Id
    @GeneratedValue
    @Column(name="key_id")
    private Integer keyId;
    @Column(name="dict_id")
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
