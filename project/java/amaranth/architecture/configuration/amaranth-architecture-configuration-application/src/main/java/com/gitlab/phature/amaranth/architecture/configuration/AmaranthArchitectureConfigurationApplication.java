package com.gitlab.phature.amaranth.architecture.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 架构配置应用类
 *
 * @author phature@qq.com
 */
@EnableConfigServer
@SpringBootApplication
public class AmaranthArchitectureConfigurationApplication {
    /**
     * 主函数
     *
     * @param arguments 参数集合
     */
    public static void main(String[] arguments) {
        SpringApplication.run(AmaranthArchitectureConfigurationApplication.class, arguments);
    }
}