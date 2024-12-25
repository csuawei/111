package com.group12.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 字典类型表
 *
 * @author qersoft
 * @email 626070918@qq.com
 * @date 2024-8-15
 */
@Data
@TableName("sys_dict_type")
public class SysDictTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字典主键
     */

    @TableId(type = IdType.AUTO)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long dictId;
    /**
     * 字典名称
     */
    private String dictName;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 创建者
     */
    private Long createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新者
     */
    private Long updateBy;
    /**
     * 删除标记：0 正常、1 已删除
     */
    private Integer delFlag;
    /**
     * 前端是否显示：0显示、1不显示
     */
    private Integer frontShow;
    /**
     * 后端是否显示：0显示、1不显示
     */
    private Integer backShow;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    @TableField(exist = false)
    private String remark;

    private String sysId;

}
