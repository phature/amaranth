package com.gitlab.phature.amaranth.test.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 测试存储应用类
 *
 * @author phature@qq.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AmaranthTestStorageApplication {
    /**
     * 主函数
     *
     * @param arguments 参数集合
     */
    public static void main(String[] arguments) {
        SpringApplication.run(AmaranthTestStorageApplication.class, arguments);
    }
}