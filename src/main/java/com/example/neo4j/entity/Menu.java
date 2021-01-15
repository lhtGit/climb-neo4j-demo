package com.example.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lht
 * @since 2021/1/13 11:43
 */
@Data
@TableName("sys_auth_menu")
public class Menu {
    private String id;
    private String name;
    @TableField("parent_id")
    private String parentId;
}
