package com.bestoyc.ssmdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ouyangcheng
 *
 */
@SpringBootApplication
@MapperScan(value = "com.bestoyc.ssmdemo.mapper") //扫描的mapper文件路径
public class SsmdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmdemoApplication.class, args);
    }

}
