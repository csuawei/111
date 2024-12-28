package com.group12.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@TableName("automaticmark")
public class AutomaticMarkEntity {
    @TableId
    private Long score;

    private String answer;

}
