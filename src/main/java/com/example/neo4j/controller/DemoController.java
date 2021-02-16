package com.example.neo4j.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.climb.common.util.IdUtils;
import com.example.neo4j.dao.SysDicDataDao;
import com.example.neo4j.entity.SysDicData;
import com.example.neo4j.neo4j.dao.Neo4jDemoDao;
import com.example.neo4j.neo4j.dao.TestRelationshipDao;
import com.example.neo4j.neo4j.entity.Neo4jDemo;
import com.example.neo4j.neo4j.entity.TestRelationship;
import com.example.neo4j.neo4j.service.Neo4jService;
import com.google.common.collect.Lists;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;


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
    @Autowired
    private Neo4jService neo4jService;
    @Autowired
    private TestRelationshipDao testRelationshipDao;

    /**
     * 创建关联关系
     * @author lht
     * @since  2021/2/16 9:45
     * @param formId
     * @param toId
     */
    @GetMapping("create/relationship")
    public void createRelationship(String formId,String toId){
        TestRelationship testRelationship = new TestRelationship();
        testRelationship.setName("test");
        testRelationship.setFormId(formId);
        testRelationship.setToId(toId);
        testRelationship.setTestTitle("testTilte");
        testRelationshipDao.insert(testRelationship,"Neo4jDemo","Neo4jDemo");
    }
    /**
     * 测试seata分布式事务关联mysql和neo4j的事务
     * @author lht
     * @since  2021/1/26 14:33
     */
    @GetMapping("add")
    @Transactional
    @GlobalTransactional
    public String addData(){
        SysDicData sysDicData = new SysDicData();

        sysDicData.setPid(10086);
        sysDicData.setCode("seata code");
        sysDicData.setName("seata name");
        sysDicDataDao.insert(sysDicData);
        neo4jCreate("demo1");
        if(1==1)throw new RuntimeException("exception");
        return "ok";
    }

    /**
     * SysDicData find all
     * @author lht
     * @since  2021/1/6 14:04
     * @param
     */

    @GetMapping("data")
    public Collection<SysDicData> dataList(){
        LambdaQueryWrapper<SysDicData> lambdaQueryWrapper = Wrappers.lambdaQuery();
        return sysDicDataDao.selectList(lambdaQueryWrapper);
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
        demoPage.setOrders(Lists.newArrayList(OrderItem.desc("n.name")));
        Page<Neo4jDemo> o =  neo4jDemoDao.findAll(demoPage);
        return o;
    }

    /**
     *  create neo4j demo
     * @author lht
     * @since  2021/1/6 14:05
     * @param name
     */
    @Transactional
    @GetMapping("create/neo4j/demo")
    public int neo4jCreate(String name){
        Neo4jDemo neo4jDemo = new Neo4jDemo();
        neo4jDemo.setId(IdUtils.nextId());
        neo4jDemo.setAmount(new BigDecimal("1.038"));
        neo4jDemo.setStatus(1);
        neo4jDemo.setName(name);
        neo4jDemo.setTestTitle("test title");
        neo4jDemoDao.insert(neo4jDemo);
        return 1;
    }

    /**
     * update neo4j demo
     * @author lht
     * @since  2021/1/8 17:22
     * @param name
     * @param val
     */
    @GetMapping("update/neo4j/demo")
    public int neo4jUpdate(String name,Integer val){
        Neo4jDemo neo4jDemo = new Neo4jDemo();
        neo4jDemo.setName(name);
        Neo4jDemo neo4jDemoVal = new Neo4jDemo();
        neo4jDemoVal.setStatus(val);
        return neo4jDemoDao.update(neo4jDemo,neo4jDemoVal);
    }

    /**
     * delete neo4j demo
     * @author lht
     * @since  2021/1/8 17:22
     * @param name
     */
    @GetMapping("delete/neo4j/demo")
    public int neo4jDelete(String name){
        Neo4jDemo neo4jDemo = new Neo4jDemo();
        neo4jDemo.setName(name);
        return neo4jDemoDao.delete(neo4jDemo);
    }

    /**
     * update neo4j demo
     * @author lht
     * @since  2021/1/8 17:22
     * @param name
     * @param val
     */
    @GetMapping("update/neo4j/demo/{name}")
    public int neo4jUpdateById(@PathVariable String name, Integer val){
        Neo4jDemo neo4jDemoVal = new Neo4jDemo();
        neo4jDemoVal.setStatus(val);
        return neo4jDemoDao.updateById(name,neo4jDemoVal);
    }

    /**
     * delete neo4j demo
     * @author lht
     * @since  2021/1/8 17:22
     * @param name
     */
    @GetMapping("delete/neo4j/demo/{name}")
    public int neo4jDeleteById(@PathVariable String name){
        return neo4jDemoDao.deleteById(name);
    }



    /**
     * 测试neo4j 批量保存
     * @author lht
     * @since  2021/2/2 16:41
     * @param
     */
    @GetMapping("saveBatch")
    public void saveBatch(){
        Neo4jDemo neo4jDemo = Neo4jDemo.builder().name("demo1").build();
        Neo4jDemo neo4jDemo2 = Neo4jDemo.builder().name("demo2").build();
        Neo4jDemo neo4jDemo3 = Neo4jDemo.builder().name("demo3").build();
        Neo4jDemo neo4jDemo4 = Neo4jDemo.builder().name("demo4").build();
        List<Neo4jDemo> list = Lists.newArrayList(neo4jDemo,neo4jDemo2,neo4jDemo3,neo4jDemo4);

        neo4jService.saveBatch(list,2);
    }

}