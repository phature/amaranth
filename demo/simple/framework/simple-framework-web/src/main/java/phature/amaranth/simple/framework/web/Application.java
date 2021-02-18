package phature.amaranth.simple.framework.web;

import phature.amaranth.simple.framework.configuration.Configurator;
import phature.amaranth.simple.framework.ioc.Inject;
import phature.amaranth.simple.framework.utility.StringHandler;
import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;
import phature.amaranth.simple.framework.web.configurator.ServerJsonFileConfigurator;
import phature.amaranth.simple.framework.web.server.Server;

/**
 * 应用类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-15
 */
public class Application {
    private static Server server;

    public static void start() {
        Configurator configurator = new ServerJsonFileConfigurator();
        configurator.read();

        ServerConfiguration serverConfiguration = WebVariate.getServerConfiguration();
        if (null != serverConfiguration) {
            String serverClass = serverConfiguration.getServerClass();
            if (!StringHandler.empty(serverClass)) {
                server = Inject.instance(Server.class, serverClass);
                if (null != server) {
                    server.start(serverConfiguration);
                }
            }
        }
    }

    public static void stop() {
        if (null != server) {
            server.stop();
        }
    }
}
