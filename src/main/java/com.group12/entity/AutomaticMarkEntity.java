package com.group12.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@TableName("automaticmark")
public class AutomaticMarkEntity {
    private Long score;
    private Long id;
    private String correctAnswer;
    private String studentAnswer;
    private String questionContents;
    private String questionType;

}
