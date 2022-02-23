package phature.amaranth.simple.framework.web.configurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.json.AbstractJsonFileConfigurator;
import phature.amaranth.simple.framework.web.WebVariate;
import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;

/**
 * 服务器JSON文件配置器类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-08
 */
public class ServerJsonFileConfigurator extends AbstractJsonFileConfigurator<ServerConfiguration> {
    private final static Logger logger = LoggerFactory.getLogger(ServerJsonFileConfigurator.class);

    @Override
    protected ServerConfiguration getConfiguration() {
        return WebVariate.getServerConfiguration();
    }

    @Override
    protected void setConfiguration(ServerConfiguration configuration) {
        WebVariate.setServerConfiguration(configuration);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Class<ServerConfiguration> getConfigurationClass() {
        return ServerConfiguration.class;
    }
}
