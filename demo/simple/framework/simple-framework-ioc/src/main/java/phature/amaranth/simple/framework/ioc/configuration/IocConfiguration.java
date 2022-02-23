package phature.amaranth.simple.framework.ioc.configuration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 依赖注入配置类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class IocConfiguration {
    private ConcurrentHashMap<String, String> defaultInstances;

    /**
     * 获取默认实例集合
     *
     * @return 默认实例集合
     */
    public ConcurrentHashMap<String, String> getDefaultInstances() {
        return defaultInstances;
    }

    /**
     * 设置默认实例集合
     *
     * @param defaultInstances 默认实例集合
     */
    public void setDefaultInstances(ConcurrentHashMap<String, String> defaultInstances) {
        this.defaultInstances = defaultInstances;
    }
}
