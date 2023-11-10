package com.dormManage.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.dormManage"})
@MapperScan("com.dormManage.system.mapper")
public class DormManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(DormManageApplication.class,args);
    }
}


