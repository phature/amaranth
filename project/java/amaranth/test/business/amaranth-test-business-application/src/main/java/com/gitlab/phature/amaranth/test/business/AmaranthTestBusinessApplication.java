package com.gitlab.phature.amaranth.test.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试业务应用类
 *
 * @author phature@qq.com
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class AmaranthTestBusinessApplication {
    /**
     * 主函数
     *
     * @param arguments 参数集合
     */
    public static void main(String[] arguments) {
        SpringApplication.run(AmaranthTestBusinessApplication.class, arguments);
    }
}