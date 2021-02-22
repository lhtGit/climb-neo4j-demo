package com.example.neo4j.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.climb.mybatis.injector.neo4j.relationship.annotation.FormRelationship;
import com.climb.mybatis.injector.neo4j.relationship.annotation.ToRelationship;
import lombok.Data;

/**
 * @author lht
 * @since 2021/2/14 14:55
 */
@Data
@TableName("TestRelationship")
public class TestRelationship {

    @FormRelationship("Neo4jDemo")
    private String formId;
    @ToRelationship("Neo4jDemo")
    private String toId;
    private String name;
    private String testTitle;
}
