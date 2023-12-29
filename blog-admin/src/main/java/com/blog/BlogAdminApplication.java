package com.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@MapperScan("com.blog.modules.sys.dao")
@SpringBootApplication
public class BlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }

}
