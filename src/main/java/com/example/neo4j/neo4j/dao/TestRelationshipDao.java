package com.example.neo4j.neo4j.dao;

import com.climb.mybatis.injector.neo4j.relationship.RelationshipMapper;
import com.example.neo4j.neo4j.entity.TestRelationship;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/2/14 14:56
 */
@Repository
public interface TestRelationshipDao extends RelationshipMapper<TestRelationship> {
}
