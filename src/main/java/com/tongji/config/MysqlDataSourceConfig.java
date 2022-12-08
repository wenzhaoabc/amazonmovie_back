package com.tongji.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Mysql数据源配置，默认数据源
 */

@Configuration
@MapperScan(basePackages = "com.tongji.mapper.mysql", sqlSessionFactoryRef = "MySqlSessionFactory")
public class MysqlDataSourceConfig {

    @Bean(name = "MysqlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource getMysqlDataSource() {
        /**
         * 该DataSource函数存在两种路径
         */
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "MySqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSessionFactory(@Qualifier("MysqlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/tongji/mapper/mysql/*.xml"));
        return bean.getObject();
    }

    @Bean("MysqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mysqlSessionTemplate(@Qualifier("MySqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
