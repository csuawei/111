package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

@Data
@TableName("automaticmark")
public class AutomaticMarkEntity {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Integer score;
    private String correctAnswer;
    private String studentAnswer;
    private String questionContents;
    private String questionType;
    private LocalDateTime createTime;
    private Long creatBy;

}
