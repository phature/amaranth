package phature.amaranth.simple.framework.controller;

/**
 * 控制器常量类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-21
 */
public class ControllerConstant {
    /**
     * 默认格式化器
     */
    public final static String DEFAULT_FORMATTER = "json";

    /**
     * 错误类
     */
    public static class Error {
        /**
         * 无错误
         */
        public final static int NONE = 0;
        /**
         * 异常错误
         */
        public final static int EXCEPTION = 101;
        /**
         * 配置错误
         */
        public final static int CONFIGURATION = 201;
        /**
         * 安全错误
         */
        public final static int SECURITY = 301;
        /**
         * 控制器错误
         */
        public final static int CONTROLLER = 401;
        /**
         * 类错误
         */
        public final static int CLASS = 501;
        /**
         * 方法错误
         */
        public final static int METHOD = 601;
        /**
         * 参数错误
         */
        public final static int PARAMETER = 701;
    }

    /**
     * 头类
     */
    public final static class Header {
        /**
         * 格式化器
         */
        public static String FORMATTER = "amaranth-formatter";
        /**
         * 错误
         */
        public final static String ERROR = "amaranth-error";
    }
}
