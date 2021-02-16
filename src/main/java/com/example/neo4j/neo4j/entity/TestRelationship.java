package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.climb.mybatis.injector.neo4j.relationship.bean.BaseRelationship;
import lombok.Data;

/**
 * @author lht
 * @since 2021/2/14 14:55
 */
@Data
@TableName("TestRelationship")
public class TestRelationship extends BaseRelationship {
    private String name;
    private String testTitle;
}
