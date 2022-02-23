package phature.amaranth.simple.framework.web.server;

import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;

/**
 * 服务器抽象类
 *
 * @param <EmbedServer> 嵌入式服务器
 * @author phature@qq.com
 * @date 2020-12-02
 * @date 2020-12-12
 */
public abstract class AbstractServer<EmbedServer> implements Server {
    /**
     * 获取嵌入式服务器
     *
     * @return 嵌入式服务器
     */
    protected abstract EmbedServer getEmbedServer();

    /**
     * 启动嵌入式服务器
     *
     * @param serverConfiguration 服务器配置
     */
    protected abstract void startEmbedServer(ServerConfiguration serverConfiguration);

    /**
     * 停止嵌入式服务器
     */
    protected abstract void stopEmbedServer();

    @Override
    public void start(ServerConfiguration serverConfiguration) {
        if (null == getEmbedServer()) {
            startEmbedServer(serverConfiguration);
        }
    }

    @Override
    public void stop() {
        if (null != getEmbedServer()) {
            stopEmbedServer();
        }
    }
}
