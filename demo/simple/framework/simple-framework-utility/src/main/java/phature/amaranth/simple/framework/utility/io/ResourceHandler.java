package phature.amaranth.simple.framework.utility.io;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.utility.StringHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-04
 * @date 2020-12-15
 */
public class ResourceHandler {
    /**
     * 日志器
     */
    private final static Logger logger = LoggerFactory.getLogger(ResourceHandler.class);

    /**
     * 读
     *
     * @param resource 资源
     * @return 内容
     */
    public static String read(String resource) {
        String result = null;

        if (!StringHandler.empty(resource)) {
            try (InputStream inputStream = ResourceHandler.class.getResourceAsStream(resource)) {
                if (null != inputStream) {
                    result = IOUtils.toString(inputStream);
                }
            } catch (IOException exception) {
                logger.error(exception.getMessage(), exception);
            }
        }

        return result;
    }
}
