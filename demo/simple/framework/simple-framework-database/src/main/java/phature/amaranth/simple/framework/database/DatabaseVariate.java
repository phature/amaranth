package phature.amaranth.simple.framework.database;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据库变量类
 *
 * @author phature@qq.com
 * @date 2020-12-21
 * @date 2020-12-22
 */
public class DatabaseVariate {
    private final static ConcurrentHashMap<String, DataSource> DATA_SOURCES = new ConcurrentHashMap<>(ConfigurationConstant.Map.TINY_INITIAL_CAPACITY);

    /**
     * 获取数据源集合
     *
     * @return 数据源集合
     */
    public static ConcurrentHashMap<String, DataSource> getDataSources() {
        return DATA_SOURCES;
    }
}
