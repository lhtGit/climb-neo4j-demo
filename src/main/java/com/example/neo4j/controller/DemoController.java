package com.example.neo4j.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.neo4j.dao.SysDicDataDao;
import com.example.neo4j.entity.SysDicData;
import com.example.neo4j.neo4j.dao.Neo4jDemoDao;
import com.example.neo4j.neo4j.entity.Neo4jDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Collection;


/**
 * 字典值(SysDicData)表控制层
 *
 * @author lht
 * @since 2021-01-05 18:29:31
 */
@RestController
public class DemoController {
    /**
     * 服务对象
     */
    @Resource
    private SysDicDataDao sysDicDataDao;

    @Resource
    private Neo4jDemoDao neo4jDemoDao;


    /**
     * SysDicData find all
     * @author lht
     * @since  2021/1/6 14:04
     * @param
     */
    @GetMapping("data")
    public Collection<SysDicData> dataList(){
        return sysDicDataDao.selectList(null);
    }

    /**
     * neo4j demo find all
     * @author lht
     * @since  2021/1/6 14:04
     * @param
     */
    @GetMapping("neo4j/demo")
    public Page<Neo4jDemo> neo4jDemoList(int page,int size){
        Page<Neo4jDemo> demoPage = new Page<>(page,size);
        return neo4jDemoDao.findAll(demoPage);
    }

    /**
     *  create neo4j demo
     * @author lht
     * @since  2021/1/6 14:05
     * @param name
     */
    @GetMapping("create/neo4j/demo")
    public int neo4jCreate(String name){
        Neo4jDemo neo4jDemo = new Neo4jDemo();
        neo4jDemo.setAmount(new BigDecimal("1.038"));
        neo4jDemo.setStatus(1);
        neo4jDemo.setName(name);
        return neo4jDemoDao.addDemo(neo4jDemo);
    }


}