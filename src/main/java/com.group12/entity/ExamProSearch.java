package com.group12.entity;

import lombok.Data;

@Data
public class ExamProSearch {

    private Long id;

    private Integer pageNo;

    private Integer pageSize;

    private String probody;

    private Integer diff;

    private String course;

    private String knowpoint;

    private String protype;

}
