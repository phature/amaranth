package phature.amaranth.simple.framework.ioc.configurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.json.AbstractJsonFileConfigurator;
import phature.amaranth.simple.framework.ioc.IocVariate;
import phature.amaranth.simple.framework.ioc.configuration.IocConfiguration;

/**
 * 依赖注入JSON文件配置器类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class IocJsonFileConfigurator extends AbstractJsonFileConfigurator<IocConfiguration> {
    private final static Logger logger = LoggerFactory.getLogger(IocJsonFileConfigurator.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Class<IocConfiguration> getConfigurationClass() {
        return IocConfiguration.class;
    }

    @Override
    protected IocConfiguration getConfiguration() {
        return IocVariate.getIocConfiguration();
    }

    @Override
    protected void setConfiguration(IocConfiguration configuration) {
        IocVariate.setIocConfiguration(configuration);
    }
}
