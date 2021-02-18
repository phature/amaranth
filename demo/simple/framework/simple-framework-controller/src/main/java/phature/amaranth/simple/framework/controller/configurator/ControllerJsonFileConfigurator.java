package phature.amaranth.simple.framework.controller.configurator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.json.AbstractJsonFileConfigurator;
import phature.amaranth.simple.framework.controller.ControllerVariate;
import phature.amaranth.simple.framework.controller.configuration.ControllerConfiguration;

/**
 * 控制器JSON文件配置器类
 *
 * @author phature@qq.com
 * @date 2020-12-12
 * @date 2020-12-12
 */
public class ControllerJsonFileConfigurator extends AbstractJsonFileConfigurator<ControllerConfiguration> {
    private final static Logger logger = LoggerFactory.getLogger(ControllerJsonFileConfigurator.class);

    @Override
    public ControllerConfiguration getConfiguration() {
        return ControllerVariate.getControllerConfiguration();
    }

    @Override
    public void setConfiguration(ControllerConfiguration configuration) {
        ControllerVariate.setControllerConfiguration(configuration);
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Class<ControllerConfiguration> getConfigurationClass() {
        return ControllerConfiguration.class;
    }
}
