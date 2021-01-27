package com.example.neo4j.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.climb.mybatis.page.interceptor.ExtensionPaginationInnerInterceptor;
import com.climb.neo4j.constant.Neo4jConstant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author lht
 * @since 2021/1/6 09:57
 */
@Configuration
@MapperScan(basePackages  = {"com.example.neo4j.dao"},sqlSessionTemplateRef  ="mysqlSqlSessionTemplate")
public class MysqlMybatisConfig {
    @Bean("mysqlDatasource")
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSource getDataSource() throws Exception{
        return new DruidDataSource();
    }


    @Bean("mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory neo4SqlSessionFactory(@Qualifier("mysqlDatasource") DataSource dataSource, MybatisPlusProperties mybatisProperties) throws Exception {
        MybatisSqlSessionFactoryBean fb = new MybatisSqlSessionFactoryBean();
        fb.setDataSource(dataSource);
        fb.setConfiguration(mybatisProperties.getConfiguration());
        //配饰插件 分页、
        fb.setPlugins(mybatisPlusInterceptor());
        Resource[] resources=new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml");
        fb.setMapperLocations(resources);
        return fb.getObject();
    }

    @Bean(name = "mysqlSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate neo4jSqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public DataSourceTransactionManager  transactionManager(@Qualifier("mysqlDatasource") DataSource prodDataSource) {
        return new DataSourceTransactionManager(prodDataSource);
    }
    /**
     * 使用mybatis的分页插件 ，该分页插件已经扩展为可以用于neo4j
     */
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new ExtensionPaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
