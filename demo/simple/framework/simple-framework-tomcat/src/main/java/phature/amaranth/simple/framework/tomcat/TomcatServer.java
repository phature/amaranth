package phature.amaranth.simple.framework.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.AbstractProtocol;
import org.apache.coyote.ProtocolHandler;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.StringHandler;
import phature.amaranth.simple.framework.web.configuration.ConnectorConfiguration;
import phature.amaranth.simple.framework.web.configuration.FilterConfiguration;
import phature.amaranth.simple.framework.web.configuration.HttpServletConfiguration;
import phature.amaranth.simple.framework.web.configuration.ServerConfiguration;
import phature.amaranth.simple.framework.web.server.AbstractServer;

import java.util.List;

/**
 * Tomcat服务器类
 *
 * @author phature@qq.com
 * @date 2020-12-01
 * @date 2020-12-12
 */
public class TomcatServer extends AbstractServer<Tomcat> {
    private final static Logger logger = LoggerFactory.getLogger(TomcatServer.class);
    private static Tomcat tomcat;

    @Override
    protected Tomcat getEmbedServer() {
        return tomcat;
    }

    /**
     * 配置上下文
     *
     * @param serverConfiguration 服务器配置
     * @param secure              安全
     * @param context             上下文
     */
    private void configureContext(ServerConfiguration serverConfiguration, boolean secure, Context context) {
        context.setReloadable(false);
        if (secure) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            SecurityCollection securityCollection = new SecurityCollection();
            securityCollection.addPattern("/*");
            securityConstraint.addCollection(securityCollection);
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            context.addConstraint(securityConstraint);
        }

        List<String> listeners = serverConfiguration.getListeners();
        if (null != listeners) {
            for (String listener : listeners) {
                if (!StringHandler.empty(listener)) {
                    context.addApplicationListener(listener);
                }
            }
        }

        List<FilterConfiguration> filterConfigurations = serverConfiguration.getFilters();
        if (null != filterConfigurations) {
            FilterDef filterDef;
            FilterMap filterMap;
            for (FilterConfiguration filterConfiguration : filterConfigurations) {
                if (null != filterConfiguration) {
                    filterDef = new FilterDef();
                    filterDef.setFilterName(filterConfiguration.getName());
                    filterDef.setFilterClass(filterConfiguration.getName());

                    filterMap = new FilterMap();
                    filterMap.setFilterName(filterConfiguration.getName());
                    if (null != filterConfiguration.getPatterns()) {
                        for (String pattern : filterConfiguration.getPatterns()) {
                            filterMap.addURLPattern(pattern);
                        }
                    }
                    filterMap.setDispatcher(filterConfiguration.getDispatcher());

                    context.addFilterDef(filterDef);
                    context.addFilterMap(filterMap);
                }
            }
        }

        List<HttpServletConfiguration> httpServletConfigurations = serverConfiguration.getServlets();
        if (null != httpServletConfigurations) {
            for (HttpServletConfiguration httpServletConfiguration : httpServletConfigurations) {
                Tomcat.addServlet(context, httpServletConfiguration.getName(), httpServletConfiguration.getName());
                if (null != httpServletConfiguration.getPatterns()) {
                    for (String pattern : httpServletConfiguration.getPatterns()) {
                        context.addServletMappingDecoded(pattern, httpServletConfiguration.getName());
                    }
                }
            }
        }
    }

    /**
     * 配置连接器
     *
     * @param serverConfiguration 服务器配置
     * @param secure              安全
     * @param httpConnector       HTTP连接器
     * @param httpsConnector      HTTPS连接器
     */
    private void configureConnector(ServerConfiguration serverConfiguration, boolean secure, Connector httpConnector, Connector httpsConnector) {
        Connector connector;
        ConnectorConfiguration connectorConfiguration = serverConfiguration.getConnector();
        if (null != connectorConfiguration) {
            httpConnector.setPort(connectorConfiguration.getHttpPort());
            if (secure) {
                httpConnector.setRedirectPort(connectorConfiguration.getHttpsPort());
                httpsConnector.setPort(connectorConfiguration.getHttpsPort());
                connector = httpsConnector;
            } else {
                connector = httpConnector;
            }

            ProtocolHandler protocolHandler = connector.getProtocolHandler();
            if (protocolHandler instanceof AbstractProtocol) {
                AbstractProtocol<?> abstractProtocol = (AbstractProtocol<?>) protocolHandler;
                abstractProtocol.setConnectionTimeout(connectorConfiguration.getConnectionTimeout());
                abstractProtocol.setMaxThreads(connectorConfiguration.getMaxThreads());
                abstractProtocol.setMaxConnections(connectorConfiguration.getMaxConnections());
                abstractProtocol.setAcceptCount(connectorConfiguration.getAcceptCount());
            }

            if (protocolHandler instanceof AbstractHttp11Protocol) {
                AbstractHttp11Protocol<?> abstractHttp11Protocol = (AbstractHttp11Protocol<?>) protocolHandler;
                abstractHttp11Protocol.setCompressionMinSize(connectorConfiguration.getCompressionMinSize());
                abstractHttp11Protocol.setCompression(connectorConfiguration.getCompression());
                abstractHttp11Protocol.setCompressibleMimeType(connectorConfiguration.getCompressibleMimeType());

                if (secure) {
                    abstractHttp11Protocol.setSSLEnabled(true);
                    abstractHttp11Protocol.setClientAuth(SSLHostConfig.CertificateVerification.NONE.name());
                    abstractHttp11Protocol.setSslProtocol("TLS");

                    abstractHttp11Protocol.setKeystoreType(connectorConfiguration.getKeystoreType());
                    abstractHttp11Protocol.setKeystoreFile(
                            StringHandler.connect(
                                    ConfigurationConstant.Io.FILE_SEPARATOR,
                                    ConfigurationVariate.getRootDirectory().getPath(),
                                    ConfigurationConstant.Io.CONFIGURATION_DIRECTORY,
                                    connectorConfiguration.getKeystoreFile()
                            )
                    );
                    abstractHttp11Protocol.setKeystorePass(connectorConfiguration.getKeystorePass());
                    abstractHttp11Protocol.setKeyAlias(connectorConfiguration.getKeyAlias());
                }
            }
        }
    }

    @Override
    protected void startEmbedServer(ServerConfiguration serverConfiguration) {
        try {
            tomcat = new Tomcat();
            tomcat.setHostname(serverConfiguration.getHostname());
            tomcat.setBaseDir(serverConfiguration.getBaseDir());
            boolean secure = serverConfiguration.isSecure();

            Context context = tomcat.addWebapp(serverConfiguration.getContextPath(), serverConfiguration.getDocBase());
            configureContext(serverConfiguration, secure, context);

            Connector httpConnector = new Connector();
            Connector httpsConnector = secure ? new Connector() : null;

            configureConnector(serverConfiguration, secure, httpConnector, httpsConnector);
            tomcat.setConnector(httpConnector);
            if (secure) {
                tomcat.setConnector(httpsConnector);
            }

            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException exception) {
            logger.error(exception.getMessage(), exception);
        }
    }

    @Override
    protected void stopEmbedServer() {
        try {
            tomcat.stop();
        } catch (LifecycleException exception) {
            logger.error(exception.getMessage(), exception);
        }
    }
}
