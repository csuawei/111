package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("examprochoose")
public class ExamProChooseEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String probody;
    private int diff;
    private int score;
    private String ans;
    private String choose1;
    private String choose2;
    private String choose3;
    private String choose4;
    private String knowpoint;
}
