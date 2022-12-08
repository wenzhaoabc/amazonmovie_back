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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.tongji.mapper.hive", sqlSessionFactoryRef = "HiveSessionFactory")
public class HiveDataSourceConfig {
    @Bean(name = "HiveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hive")
    public DataSource hiveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "HiveSessionFactory")
    public SqlSessionFactory hiveSessionFactory(@Qualifier("HiveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/tongji/mapper/hive/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "HiveSessionTemplate")
    public SqlSessionTemplate hiveSessionTemplate(@Qualifier("HiveSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
