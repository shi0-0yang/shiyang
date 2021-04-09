package com.shiyang.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @SpringBootApplication 来标注一个主程序类，说明这是一个Spring Boot应用
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {

        boolean success=true;
        try {
            SpringApplication.run(DemoApplication.class, args);
        } catch (Exception e) {
            success=false;
            log.error("******************启动失败*****************"+e.getMessage());
        }

    }

}
