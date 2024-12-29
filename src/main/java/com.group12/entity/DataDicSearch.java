package com.group12.entity;

import lombok.Data;

@Data
public class DataDicSearch {

    private Long id;

    private Integer pageNo;

    private Integer pageSize;

    private String dicname;

    private String dictype;

}
