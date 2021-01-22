package com.example.neo4j.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * base_addr_pdd
 * @author 
 */
@Data
public class BaseAddrPdd  {
    private Integer id;

    @TableField("region_type")
    private Integer regionType;

    @TableField("region_name")
    private String regionName;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("national_code")
    private String nationalCode;

    @TableField("is_enabled")
    private Integer enabled;

}