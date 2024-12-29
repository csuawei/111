package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("exampro")
public class ExamProEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String probody;
    private int diff;
    private String course;
    private int score;
    private String ans;
    private String choose1;
    private String choose2;
    private String choose3;
    private String choose4;
    private String knowpoint;
    private int protype;
}
