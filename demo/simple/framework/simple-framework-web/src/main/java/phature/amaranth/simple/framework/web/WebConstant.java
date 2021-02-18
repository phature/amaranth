package phature.amaranth.simple.framework.web;

/**
 * WEB常量W类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-15
 */
public class WebConstant {
    /**
     * 服务器类
     */
    public static class Server {
        /**
         * 默认主机
         */
        public final static String DEFAULT_HOSTNAME = "127.0.0.1";
        /**
         * 基础目录
         */
        public final static String DEFAULT_BASE_DIRECTORY = "web";
        /**
         * 文档目录
         */
        public final static String DEFAULT_DOCUMENT_DIRECTORY = "static";
    }

    /**
     * 连接器类
     */
    public static class Connector {
        /**
         * 默认HTTP端口
         */
        public final static Integer DEFAULT_HTTP_PORT = 16384;
        /**
         * 默认HTTPS端口
         */
        public final static Integer DEFAULT_HTTPS_PORT = 32768;
        /**
         * 默认连接超时毫秒数
         */
        public final static Integer CONNECTION_TIMEOUT_DEFAULT = 1000;
        /**
         * 默认最大线程数
         */
        public final static Integer DEFAULT_MAX_THREADS = 4096;
        /**
         * 默认最大连接数
         */
        public final static Integer DEFAULT_MAX_CONNECTIONS = 32768;
        /**
         * 默认接受总数
         */
        public final static Integer DEFAULT_ACCEPT_COUNT = 512;
        /**
         * 默认压缩最小大小
         */
        public final static Integer DEFAULT_COMPRESSION_MIN_SIZE = 8192;
        /**
         * 默认压缩
         */
        public final static String DEFAULT_COMPRESSION = Compression.ON.getValue();
        /**
         * 默认可压缩媒体类型
         */
        public final static String DEFAULT_COMPRESSIBLE_MIME_TYPE = "text/html,text/xml,text/plain,text/css,text/javascript,application/javascript,application/json,application/xml";
    }
}
