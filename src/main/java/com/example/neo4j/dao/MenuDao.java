package com.example.neo4j.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.neo4j.entity.Menu;
import org.springframework.stereotype.Repository;

/**
 * @author lht
 * @since 2021/1/13 11:46
 */
@Repository
public interface MenuDao extends BaseMapper<Menu> {
}
