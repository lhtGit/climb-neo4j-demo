package com.example.neo4j.neo4j.dao;

import com.climb.mybatis.injector.neo4j.Neo4jMapper;
import com.example.neo4j.neo4j.entity.Neo4jMenu;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/1/13 11:44
 */
@Repository
public interface Neo4jMenuDao extends Neo4jMapper<Neo4jMenu> {
}
