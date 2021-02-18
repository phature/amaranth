package phature.amaranth.simple.framework.web.listener;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.configuration.Configurator;
import phature.amaranth.simple.framework.configuration.configuration.ConfiguratorConfiguration;
import phature.amaranth.simple.framework.configuration.configurator.ConfiguratorJsonFileConfigurator;
import phature.amaranth.simple.framework.ioc.Inject;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.util.List;

/**
 * 默认服务上下文监听器类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-15
 */
public class DefaultServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        if (null == ConfigurationVariate.getRootDirectory()) {
            File applicationDirectory = new File(DefaultServletContextListener.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile();
            File rootDirectory = new File(
                    StringHandler.connect(
                            ConfigurationConstant.Io.FILE_SEPARATOR,
                            applicationDirectory.getPath(),
                            ConfigurationConstant.Io.CLASSES_DIRECTORY
                    )
            );
            ConfigurationVariate.setRootDirectory(rootDirectory);
        }

        Configurator configuratorConfigurator = new ConfiguratorJsonFileConfigurator();
        configuratorConfigurator.read();
        ConfiguratorConfiguration configuratorConfiguration = ConfigurationVariate.getConfiguratorConfiguration();
        if (null != configuratorConfiguration) {
            List<String> classNames = configuratorConfiguration.getClassNames();
            if (null != classNames) {
                for (String className : classNames) {
                    if (!StringHandler.empty(className)) {
                        Configurator configurator = Inject.instance(Configurator.class, className);
                        configurator.read();
                    }
                }
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}