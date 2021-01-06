package com.example.neo4j.neo4j.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lht
 * @since 2021/1/6 13:52
 */
@Data
public class Neo4jDemo {
    private String name;
    private Integer status;
    private BigDecimal amount;
}
