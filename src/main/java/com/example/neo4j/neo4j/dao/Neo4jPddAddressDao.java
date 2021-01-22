package com.example.neo4j.neo4j.dao;

import com.climb.mybatis.injector.neo4j.Neo4jMapper;
import com.example.neo4j.neo4j.entity.Neo4jPddAddress;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/1/20 09:48
 */
@Repository
public interface Neo4jPddAddressDao extends Neo4jMapper<Neo4jPddAddress> {
}
