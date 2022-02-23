package com.gitlab.phature.amaranth.architecture.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 架构网关应用类
 *
 * @author phature@qq.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AmaranthArchitectureGatewayApplication {
    /**
     * 主函数
     *
     * @param arguments 参数集合
     */
    public static void main(String[] arguments) {
        SpringApplication.run(AmaranthArchitectureGatewayApplication.class, arguments);
    }
}