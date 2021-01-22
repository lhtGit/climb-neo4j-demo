package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lht
 * @since 2021/1/20 09:43
 */
@TableName("PddAddress")
@Data
public class Neo4jPddAddress {
    private Integer id;

    @TableField("regionType")
    private Integer regionType;

    @TableField("regionName")
    private String regionName;

    @TableField("parentId")
    private Integer parentId;

    @TableField("nationalCode")
    private String nationalCode;

    @TableField("enabled")
    private Integer enabled;
}
