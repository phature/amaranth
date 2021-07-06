package com.gitlab.phature.amaranth.architecture.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 架构发现应用类
 *
 * @author phature@qq.com
 */
@EnableEurekaServer
@SpringBootApplication
public class AmaranthArchitectureDiscoveryApplication {
    /**
     * 主函数
     *
     * @param arguments 参数集合
     */
    public static void main(String[] arguments) {
        SpringApplication.run(AmaranthArchitectureDiscoveryApplication.class, arguments);
    }
}