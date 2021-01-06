package com.example.neo4j.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.neo4j.entity.SysDicData;
import org.springframework.stereotype.Repository;

/**
 * 字典值(SysDicData)表数据库访问层
 *
 * @author lht
 * @since 2021-01-05 18:29:30
 */
@Repository
public interface SysDicDataDao extends BaseMapper<SysDicData> {


}