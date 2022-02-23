package phature.amaranth.simple.framework.web.configuration;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.StringHandler;
import phature.amaranth.simple.framework.web.WebConstant;

import java.util.List;

/**
 * 服务器配置类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-15
 */
public class ServerConfiguration {
    private String serverClass;
    private List<String> configurators;
    private String hostname;
    private String baseDir;
    private String contextPath;
    private String docBase;
    private boolean secure;
    private ConnectorConfiguration connector;
    private List<String> listeners;
    private List<FilterConfiguration> filters;
    private List<HttpServletConfiguration> servlets;

    /**
     * 获取服务器类
     *
     * @return 服务器类
     */
    public String getServerClass() {
        return serverClass;
    }

    /**
     * 设置服务器类
     *
     * @param serverClass 服务器类
     */
    public void setServerClass(String serverClass) {
        this.serverClass = serverClass;
    }

    /**
     * 获取配置器集合
     *
     * @return 配置器集合
     */
    public List<String> getConfigurators() {
        return configurators;
    }

    /**
     * 设置配置器集合
     *
     * @param configurators 配置器集合
     */
    public void setConfigurators(List<String> configurators) {
        this.configurators = configurators;
    }

    /**
     * 获取主机
     *
     * @return 主机
     */
    public String getHostname() {
        return StringHandler.empty(hostname) ? WebConstant.Server.DEFAULT_HOSTNAME : hostname;
    }

    /**
     * 设置主机
     *
     * @param hostname 主机
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * 获取基础目录
     *
     * @return 基础目录
     */
    public String getBaseDir() {
        return null == baseDir ?
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        ConfigurationVariate.getRootDirectory().getPath(),
                        WebConstant.Server.DEFAULT_BASE_DIRECTORY
                ) :
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        ConfigurationVariate.getRootDirectory().getPath(),
                        baseDir
                );
    }

    /**
     * 设置基础目录
     *
     * @param baseDir 基础目录
     */
    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }

    /**
     * 获取上下文路径
     *
     * @return 上下文路径
     */
    public String getContextPath() {
        return contextPath;
    }

    /**
     * 设置上下文路径
     *
     * @param contextPath 上下文路径
     */
    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    /**
     * 获取文档目录
     *
     * @return 文档目录
     */
    public String getDocBase() {
        return null == baseDir ?
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        ConfigurationVariate.getRootDirectory().getPath(),
                        WebConstant.Server.DEFAULT_DOCUMENT_DIRECTORY
                ) :
                StringHandler.connect(
                        ConfigurationConstant.Io.FILE_SEPARATOR,
                        ConfigurationVariate.getRootDirectory().getPath(),
                        docBase
                );
    }

    /**
     * 设置文档目录
     *
     * @param docBase 文档目录
     */
    public void setDocBase(String docBase) {
        this.docBase = docBase;
    }

    /**
     * 获取安全状态
     *
     * @return 安全状态
     */
    public boolean isSecure() {
        return secure;
    }

    /**
     * 设置安全状态
     *
     * @param secure 安全状态
     */
    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    /**
     * 获取连接器配置
     *
     * @return 连接器配置
     */
    public ConnectorConfiguration getConnector() {
        return connector;
    }

    /**
     * 设置连接器配置
     *
     * @param connector 连接器配置
     */
    public void setConnector(ConnectorConfiguration connector) {
        this.connector = connector;
    }

    /**
     * 获取监听器集合
     *
     * @return 监听器集合
     */
    public List<String> getListeners() {
        return listeners;
    }

    /**
     * 设置监听器集合
     *
     * @param listeners 监听器集合
     */
    public void setListeners(List<String> listeners) {
        this.listeners = listeners;
    }

    /**
     * 获取过滤器集合
     *
     * @return 过滤器集合
     */
    public List<FilterConfiguration> getFilters() {
        return filters;
    }

    /**
     * 设置过滤器集合
     *
     * @param filters 过滤器集合
     */
    public void setFilters(List<FilterConfiguration> filters) {
        this.filters = filters;
    }

    /**
     * 获取HTTP服务小应用配置集合
     *
     * @return HTTP服务小应用配置集合
     */
    public List<HttpServletConfiguration> getServlets() {
        return servlets;
    }

    /**
     * 设置HTTP服务小应用配置集合
     *
     * @param servlets HTTP服务小应用配置集合
     */
    public void setServlets(List<HttpServletConfiguration> servlets) {
        this.servlets = servlets;
    }
}