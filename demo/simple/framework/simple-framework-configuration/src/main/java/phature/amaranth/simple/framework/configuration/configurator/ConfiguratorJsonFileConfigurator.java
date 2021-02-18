package phature.amaranth.simple.framework.configuration.configurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.configuration.configuration.ConfiguratorConfiguration;
import phature.amaranth.simple.framework.configuration.json.AbstractJsonFileConfigurator;

/**
 * 配置器JSON文件配置器类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-16
 */
public class ConfiguratorJsonFileConfigurator extends AbstractJsonFileConfigurator<ConfiguratorConfiguration> {
    private final static Logger logger = LoggerFactory.getLogger(ConfiguratorJsonFileConfigurator.class);

    @Override
    protected ConfiguratorConfiguration getConfiguration() {
        return ConfigurationVariate.getConfiguratorConfiguration();
    }

    @Override
    protected void setConfiguration(ConfiguratorConfiguration configuration) {
        ConfigurationVariate.setConfiguratorConfiguration(configuration);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Class<ConfiguratorConfiguration> getConfigurationClass() {
        return ConfiguratorConfiguration.class;
    }
}
