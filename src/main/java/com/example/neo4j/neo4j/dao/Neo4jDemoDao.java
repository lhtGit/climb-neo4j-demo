package com.example.neo4j.neo4j.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.neo4j.neo4j.entity.Neo4jDemo;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/1/6 13:54
 */
@Repository
public interface Neo4jDemoDao {
    /**
     * 创建demo节点
     * @author lht
     * @since  2021/1/6 13:55
     * @param neo4jDemo
     */
    int addDemo(Neo4jDemo neo4jDemo);

    /**
     * 查询demo所有节点 分页
     * @author lht
     * @since  2021/1/6 13:56
     * @param
     */
    Page<Neo4jDemo> findAll(Page<Neo4jDemo> page);
}
