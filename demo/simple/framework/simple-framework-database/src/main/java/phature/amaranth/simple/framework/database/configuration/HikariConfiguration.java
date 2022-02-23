package phature.amaranth.simple.framework.database.configuration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Hikari配置类
 *
 * @author phature@qq.com
 * @date 2020-12-21
 * @date 2020-12-24
 */
public class HikariConfiguration {
    private ConcurrentHashMap<String, HikariInstance> hikariInstances;

    /**
     * 获取实例集合
     *
     * @return 实例集合
     */
    public ConcurrentHashMap<String, HikariInstance> getHikariInstances() {
        return hikariInstances;
    }

    /**
     * 设置实例集合
     *
     * @param hikariInstances 实例集合
     */
    public void setHikariInstances(ConcurrentHashMap<String, HikariInstance> hikariInstances) {
        this.hikariInstances = hikariInstances;
    }
}
