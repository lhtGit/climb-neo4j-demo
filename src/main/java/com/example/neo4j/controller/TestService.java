package com.example.neo4j.controller;

import com.example.neo4j.dao.SysDicDataDao;
import com.example.neo4j.entity.SysDicData;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lht
 * @since 2021/1/22 13:37
 */
@Service
public class TestService {
    @Resource
    private SysDicDataDao sysDicDataDao;

    @GlobalTransactional
    public void s(){
        SysDicData sysDicData = new SysDicData();
        sysDicData.setName("seata name");
        sysDicData.setCode("seata code");
        sysDicData.setPid(10086);
        sysDicDataDao.insert(sysDicData);
    }
}
