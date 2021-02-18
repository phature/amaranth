package phature.amaranth.simple.framework.utility.io;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * 文件处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-04
 * @date 2020-12-15
 */
public class FileHandler {
    /**
     * 日志器
     */
    private final static Logger logger = LoggerFactory.getLogger(FileHandler.class);

    /**
     * 读
     *
     * @param file 文件
     * @return 内容
     */
    public static String read(File file) {
        String result = null;

        try {
            if (null != file) {
                result = FileUtils.readFileToString(file);
            }
        } catch (IOException exception) {
            logger.error(exception.getMessage(), exception);
        }

        return result;
    }

    /**
     * 写
     *
     * @param file    文件
     * @param content 内容
     */
    public static void write(File file, String content) {
        try {
            if (null != file) {
                FileUtils.writeStringToFile(file, content);
            }
        } catch (IOException exception) {
            logger.error(exception.getMessage(), exception);
        }
    }
}
