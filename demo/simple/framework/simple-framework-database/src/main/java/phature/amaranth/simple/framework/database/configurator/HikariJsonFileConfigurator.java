package phature.amaranth.simple.framework.database.configurator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.json.AbstractJsonFileConfigurator;
import phature.amaranth.simple.framework.database.DatabaseVariate;
import phature.amaranth.simple.framework.database.configuration.HikariConfiguration;
import phature.amaranth.simple.framework.database.configuration.HikariInstance;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Hikari的JSON文件配置器类
 *
 * @author phature@qq.com
 * @date 2020-12-21
 * @date 2020-12-25
 */
public class HikariJsonFileConfigurator extends AbstractJsonFileConfigurator<HikariConfiguration> {
    private final static Logger logger = LoggerFactory.getLogger(HikariJsonFileConfigurator.class);
    private HikariConfiguration configuration;

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected Class<HikariConfiguration> getConfigurationClass() {
        return HikariConfiguration.class;
    }

    @Override
    protected HikariConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    protected void setConfiguration(HikariConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void read() {
        super.read();

        if (null != configuration) {
            Map<String, HikariInstance> configurations = configuration.getHikariInstances();
            if (null != configurations) {
                HikariConfig hikariConfig;
                HikariInstance hikariInstance;
                DataSource dataSource;
                for (String key : configurations.keySet()) {
                    hikariInstance = configurations.get(key);
                    if (null != hikariInstance) {
                        hikariConfig = new HikariConfig();
                        hikariConfig.setJdbcUrl(hikariInstance.getJdbcUrl());
                        hikariConfig.setUsername(hikariInstance.getUsername());
                        hikariConfig.setPassword(hikariInstance.getPassword());
                        hikariConfig.setDriverClassName(hikariInstance.getDriverClassName());

                        dataSource = new HikariDataSource(hikariConfig);
                        DatabaseVariate.getDataSources().put(key, dataSource);
                    }
                }
            }
        }
    }
}
