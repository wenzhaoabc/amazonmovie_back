package com.tongji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

/**
 * mapper 三种数据源分开写
 * service目前没分开，也可以分开写
 * config目录配置三种数据源，目前hive和MySQL已测试，neo4j还没跑通
 * entity尽量统一
 */
