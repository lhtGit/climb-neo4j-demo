package com.example.neo4j.neo4j.service;

import com.climb.mybatis.service.Neo4jServiceImpl;
import com.example.neo4j.neo4j.dao.Neo4jDemoDao;
import com.example.neo4j.neo4j.entity.Neo4jDemo;
import org.springframework.stereotype.Service;

/**
 * @author lht
 * @since 2021/1/21 18:22
 */
@Service
public class Neo4jService extends Neo4jServiceImpl<Neo4jDemoDao, Neo4jDemo> {
}
