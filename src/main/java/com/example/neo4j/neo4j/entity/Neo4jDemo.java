package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lht
 * @since 2021/1/6 13:52
 */
@Data
@TableName("Neo4jDemo")
public class Neo4jDemo {
    @TableId
    private String name;
    private Integer status;
    private BigDecimal amount;
}
