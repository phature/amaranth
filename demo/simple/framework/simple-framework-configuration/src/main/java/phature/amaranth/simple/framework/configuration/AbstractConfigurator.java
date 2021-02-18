package phature.amaranth.simple.framework.configuration;

import org.slf4j.Logger;

/**
 * 配置器抽象类
 *
 * @param <ConfigurationClass> 配置类
 * @author phature@qq.com
 * @date 2020-12-12
 * @date 2020-12-15
 */
public abstract class AbstractConfigurator<ConfigurationClass> implements Configurator {
    /**
     * 获取日志器
     *
     * @return 日志器
     */
    protected abstract Logger getLogger();

    /**
     * 获取配置类
     *
     * @return 配置类
     */
    protected abstract Class<ConfigurationClass> getConfigurationClass();

    /**
     * 获取配置
     *
     * @return 配置
     */
    protected abstract ConfigurationClass getConfiguration();

    /**
     * 设置配置
     *
     * @param configuration 配置
     */
    protected abstract void setConfiguration(ConfigurationClass configuration);
}
