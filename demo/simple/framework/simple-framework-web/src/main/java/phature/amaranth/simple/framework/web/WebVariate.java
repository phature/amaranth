package phature.amaranth.simple.framework.web;

import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;

/**
 * WEB变量类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-12
 */
public class WebVariate {
    private static ServerConfiguration serverConfiguration;

    /**
     * 获取服务器配置
     *
     * @return 服务器配置
     */
    public static ServerConfiguration getServerConfiguration() {
        return serverConfiguration;
    }

    /**
     * 设置服务器配置
     *
     * @param serverConfiguration 服务器配置
     */
    public static void setServerConfiguration(ServerConfiguration serverConfiguration) {
        WebVariate.serverConfiguration = serverConfiguration;
    }
}
