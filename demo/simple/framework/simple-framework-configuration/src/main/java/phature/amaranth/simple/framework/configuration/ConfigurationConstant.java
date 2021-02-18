package phature.amaranth.simple.framework.configuration;

import java.io.File;

/**
 * 配置常量类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-17
 */
public class ConfigurationConstant {
    /**
     * 默认时间格式
     */
    public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 映射类
     */
    public static class Map {
        /**
         * 微小初始化容量
         */
        public final static int TINY_INITIAL_CAPACITY = 64;
        /**
         * 较小初始化容量
         */
        public final static int SMALL_INITIAL_CAPACITY = 256;
        /**
         * 中等初始化容量
         */
        public final static int MEDIUM_INITIAL_CAPACITY = 1024;
        /**
         * 较大初始化容量
         */
        public final static int BIG_INITIAL_CAPACITY = 4096;
    }

    /**
     * 读写类
     */
    public static class Io {
        /**
         * 空分隔符
         */
        public final static String EMPTY_SEPARATOR = "";
        /**
         * 文件分隔符
         */
        public final static String FILE_SEPARATOR = File.separator;
        /**
         * 资源分隔符
         */
        public final static String RESOURCE_SEPARATOR = "/";
        /**
         * 类集合目录
         */
        public final static String CLASSES_DIRECTORY = "classes";
        /**
         * 配置目录
         */
        public final static String CONFIGURATION_DIRECTORY = "configuration";
        /**
         * JSON文件后缀名
         */
        public final static String JSON_POSTFIX = ".json";
    }

    /**
     * 编码类
     */
    public static class Encoding {
        /**
         * UTF-8
         */
        public final static String UTF8 = "utf-8";
    }

    /**
     * 媒体类
     */
    public static class Mime {
        /**
         * HTML文本
         */
        public final static String TEXT_HTML = "text/html";
        /**
         * JSON应用
         */
        public final static String APPLICATION_JSON = "application/json";

    }
}
