package phature.amaranth.simple.framework.utility;

import java.util.UUID;

/**
 * 字符串处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-14
 */
public class StringHandler {
    /**
     * 空判断
     *
     * @param value 值
     * @return 结果
     */
    public static boolean empty(String value) {
        boolean result = true;

        if (null != value && !"".equals(value)) {
            result = false;
        }

        return result;
    }

    /**
     * 连接
     *
     * @param separator 分隔符
     * @param patterns  模式集合
     * @return 结果
     */
    public static String connect(String separator, String... patterns) {
        String result = null;

        if (null != patterns) {
            boolean first = true;
            StringBuilder stringBuilder = new StringBuilder();

            for (String pattern : patterns) {
                if (!empty(pattern)) {
                    if (first) {
                        first = false;
                    } else {
                        if (!empty(separator)) {
                            stringBuilder.append(separator);
                        }
                    }
                    if (!pattern.equals(separator)) {
                        stringBuilder.append(pattern);
                    }
                }
            }

            result = stringBuilder.toString();
        }

        return result;
    }

    /**
     * 编号
     *
     * @return 编号
     */
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
}
