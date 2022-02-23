package phature.amaranth.simple.framework.web.server;

import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;

/**
 * 服务器接口
 *
 * @author phature@qq.com
 * @date 2020-12-01
 * @date 2020-12-12
 */
public interface Server {
    /**
     * 启动
     *
     * @param serverConfiguration 服务器配置
     */
    void start(ServerConfiguration serverConfiguration);

    /**
     * 停止
     */
    void stop();
}
