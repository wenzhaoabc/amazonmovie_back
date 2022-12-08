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
@MapperScan(basePackages = "com.tongji.mapper.neo4j", sqlSessionFactoryRef = "Neo4jSessionFactory")
public class Neo4jDataSourceConfig {
    @Bean(name = "Neo4jDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.neo4j")
    public DataSource neo4jDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "Neo4jSessionFactory")
    public SqlSessionFactory neo4jSessionFactory(@Qualifier("Neo4jDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/tongji/mapper/neo4j/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "Neo4jSessionTemplate")
    public SqlSessionTemplate neo4jSessionTemplate(@Qualifier("Neo4jSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
