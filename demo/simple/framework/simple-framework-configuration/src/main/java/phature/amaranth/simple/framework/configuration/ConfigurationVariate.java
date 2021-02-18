package phature.amaranth.simple.framework.configuration;

import phature.amaranth.simple.framework.configuration.configuration.ConfiguratorConfiguration;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 * 配置变量类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-15
 */
public class ConfigurationVariate {
    private static DateFormat dateFormat = new SimpleDateFormat(ConfigurationConstant.DEFAULT_DATE_FORMAT);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(ConfigurationConstant.DEFAULT_DATE_FORMAT);
    private static File rootDirectory;
    private static String rootResource = "/";
    private static ConfiguratorConfiguration configuratorConfiguration;

    /**
     * 获取时间格式
     *
     * @return 时间格式
     */
    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * 设置时间格式
     *
     * @param dateFormat 时间格式
     */
    public static void setDateFormat(DateFormat dateFormat) {
        ConfigurationVariate.dateFormat = dateFormat;
    }

    /**
     * 获取时间格式化器
     *
     * @return 时间格式化器
     */
    public static DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    /**
     * 设置时间格式化器
     *
     * @param dateTimeFormatter 时间格式化器
     */
    public static void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        ConfigurationVariate.dateTimeFormatter = dateTimeFormatter;
    }

    /**
     * 获取根目录
     *
     * @return 根目录
     */
    public static File getRootDirectory() {
        return rootDirectory;
    }

    /**
     * 设置根目录
     *
     * @param rootDirectory 根目录
     */
    public static void setRootDirectory(File rootDirectory) {
        ConfigurationVariate.rootDirectory = rootDirectory;
    }

    /**
     * 获取根资源
     *
     * @return 根资源
     */
    public static String getRootResource() {
        return rootResource;
    }

    /**
     * 设置根资源
     *
     * @param rootResource 根资源
     */
    public static void setRootResource(String rootResource) {
    }

    /**
     * 获取配置器配置
     *
     * @return 配置器配置
     */
    public static ConfiguratorConfiguration getConfiguratorConfiguration() {
        return configuratorConfiguration;
    }

    /**
     * 设置配置器配置
     *
     * @param configuratorConfiguration 配置器配置
     */
    public static void setConfiguratorConfiguration(ConfiguratorConfiguration configuratorConfiguration) {
        ConfigurationVariate.configuratorConfiguration = configuratorConfiguration;
    }
}
