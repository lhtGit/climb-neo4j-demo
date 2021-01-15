package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lht
 * @since 2021/1/13 11:43
 */
@Data
@TableName("Neo4jMenu")
public class Neo4jMenu {
    private String id;
    private String name;
    @TableField("parentId")
    private String parentId;
}
