package com.example.neo4j.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


/**
 * 字典值(SysDicData)
 *
 * @author lht
 * @since 2021-01-05 18:29:29
 */
@Data
@TableName("sys_dic_data")
public class SysDicData implements Serializable {
    private static final long serialVersionUID = -50433089198150826L;

    /**
     * id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    /**
     * 组 code
     */
    @TableField("pid")
    private Integer pid;
    /**
     * 字典名称
     */
    @TableField("name")
    private String name;
    /**
     * 字典编码
     */
    @TableField("code")
    private String code;
    /**
     * 排序
     */
    @TableField("sort")
    private Integer sort;
    /**
     * 是否启用
     */
    @TableField("enable")
    private Boolean enable;
    /**
     * 描述
     */
    @TableField("remark")
    private String remark;


}