package phature.amaranth.simple.framework.web.configuration;

import phature.amaranth.simple.framework.utility.StringHandler;
import phature.amaranth.simple.framework.web.WebConstant;

/**
 * 连接器配置类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-08
 */
public class ConnectorConfiguration {
    private Integer httpPort;
    private Integer httpsPort;
    private Integer connectionTimeout;
    private Integer maxThreads;
    private Integer maxConnections;
    private Integer acceptCount;
    private Integer compressionMinSize;
    private String compression;
    private String compressibleMimeType;
    private String keystoreType;
    private String keystoreFile;
    private String keystorePass;
    private String keyAlias;

    /**
     * 获取HTTP端口
     *
     * @return HTTP端口
     */
    public Integer getHttpPort() {
        return null == httpPort ? WebConstant.Connector.DEFAULT_HTTP_PORT : httpPort;
    }

    /**
     * 设置HTTP端口
     *
     * @param httpPort HTTP端口
     */
    public void setHttpPort(Integer httpPort) {
        this.httpPort = httpPort;
    }

    /**
     * 获取HTTPS端口
     *
     * @return HTTPS端口
     */
    public Integer getHttpsPort() {
        return null == httpPort ? WebConstant.Connector.DEFAULT_HTTPS_PORT : httpsPort;
    }

    /**
     * 设置HTTPS端口
     *
     * @param httpsPort HTTPS端口
     */
    public void setHttpsPort(Integer httpsPort) {
        this.httpsPort = httpsPort;
    }

    /**
     * 获取连接超时毫秒数
     *
     * @return 连接超时毫秒数
     */
    public Integer getConnectionTimeout() {
        return null == connectionTimeout ? WebConstant.Connector.CONNECTION_TIMEOUT_DEFAULT : connectionTimeout;
    }

    /**
     * 设置连接超时毫秒数
     *
     * @param connectionTimeout 连接超时毫秒数
     */
    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * 获取最大线程数
     *
     * @return 最大线程数
     */
    public Integer getMaxThreads() {
        return null == maxThreads ? WebConstant.Connector.DEFAULT_MAX_THREADS : maxThreads;
    }

    /**
     * 设置最大线程数
     *
     * @param maxThreads 最大线程数
     */
    public void setMaxThreads(Integer maxThreads) {
        this.maxThreads = maxThreads;
    }

    /**
     * 获取最大连接数
     *
     * @return 最大连接数
     */
    public Integer getMaxConnections() {
        return null == maxConnections ? WebConstant.Connector.DEFAULT_MAX_CONNECTIONS : maxConnections;
    }

    /**
     * 设置最大连接数
     *
     * @param maxConnections 最大连接数
     */
    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }

    /**
     * 获取接受总数
     *
     * @return 接受总数
     */
    public Integer getAcceptCount() {
        return null == acceptCount ? WebConstant.Connector.DEFAULT_ACCEPT_COUNT : acceptCount;
    }

    /**
     * 设置接受总数
     *
     * @param acceptCount 接受总数
     */
    public void setAcceptCount(Integer acceptCount) {
        this.acceptCount = acceptCount;
    }

    /**
     * 获取压缩最小大小
     *
     * @return 压缩最小大小
     */
    public Integer getCompressionMinSize() {
        return (null == compressionMinSize) ? WebConstant.Connector.DEFAULT_COMPRESSION_MIN_SIZE : compressionMinSize;
    }

    /**
     * 设置压缩最小大小
     *
     * @param compressionMinSize 压缩最小大小
     */
    public void setCompressionMinSize(Integer compressionMinSize) {
        this.compressionMinSize = compressionMinSize;
    }

    /**
     * 获取压缩
     *
     * @return 压缩
     */
    public String getCompression() {
        return StringHandler.empty(compression) ? WebConstant.Connector.DEFAULT_COMPRESSION : compression;
    }

    /**
     * 设置压缩
     *
     * @param compression 压缩
     */
    public void setCompression(String compression) {
        this.compression = compression;
    }

    /**
     * 获取可压缩媒体类型
     *
     * @return 可压缩媒体类型
     */
    public String getCompressibleMimeType() {
        return StringHandler.empty(compressibleMimeType) ? WebConstant.Connector.DEFAULT_COMPRESSIBLE_MIME_TYPE : compressibleMimeType;
    }

    /**
     * 设置可压缩媒体类型
     *
     * @param compressibleMimeType 可压缩媒体类型
     */
    public void setCompressibleMimeType(String compressibleMimeType) {
        this.compressibleMimeType = compressibleMimeType;
    }

    /**
     * 获取密钥存储类型
     *
     * @return 密钥存储类型
     */
    public String getKeystoreType() {
        return keystoreType;
    }

    /**
     * 设置密钥存储类型
     *
     * @param keystoreType 密钥存储类型
     */
    public void setKeystoreType(String keystoreType) {
        this.keystoreType = keystoreType;
    }

    /**
     * 获取密钥存储文件
     *
     * @return 密钥存储文件
     */
    public String getKeystoreFile() {
        return keystoreFile;
    }

    /**
     * 设置密钥存储文件
     *
     * @param keystoreFile 密钥存储文件
     */
    public void setKeystoreFile(String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    /**
     * 获取密钥存储验证密码
     *
     * @return 密钥存储验证密码
     */
    public String getKeystorePass() {
        return keystorePass;
    }

    /**
     * 设置密钥存储验证密码
     *
     * @param keystorePass 密钥存储验证密码
     */
    public void setKeystorePass(String keystorePass) {
        this.keystorePass = keystorePass;
    }

    /**
     * 获取密钥昵称
     *
     * @return 密钥昵称
     */
    public String getKeyAlias() {
        return keyAlias;
    }

    /**
     * 设置密钥昵称
     *
     * @param keyAlias 密钥昵称
     */
    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }
}