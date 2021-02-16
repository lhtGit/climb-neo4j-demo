package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.asn1.pkcs.Pfx;

import java.math.BigDecimal;

/**
 * @author lht
 * @since 2021/1/6 13:52
 */
@Data
@Builder
@TableName("Neo4jDemo")
@NoArgsConstructor
@AllArgsConstructor
public class Neo4jDemo {
    @TableId
    private String id;
    private String name;
    private Integer status;
    private BigDecimal amount;
    private String testTitle;
}
