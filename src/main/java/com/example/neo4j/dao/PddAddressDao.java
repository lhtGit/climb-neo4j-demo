package com.example.neo4j.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.neo4j.entity.BaseAddrPdd;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/1/18 14:53
 */
@Repository
public interface PddAddressDao extends BaseMapper<BaseAddrPdd> {
}
