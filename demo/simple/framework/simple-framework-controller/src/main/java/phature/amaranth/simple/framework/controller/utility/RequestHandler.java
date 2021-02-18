package phature.amaranth.simple.framework.controller.utility;

import phature.amaranth.simple.framework.controller.ControllerConstant;
import phature.amaranth.simple.framework.controller.ControllerVariate;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 请求处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-21
 */
public class RequestHandler {
    /**
     * 获取值
     *
     * @param httpServletRequest 请求
     * @param key                键
     * @param value              值
     * @return 值
     */
    public static String getValue(HttpServletRequest httpServletRequest, String key, String value) {
        String result = value;

        if (null != httpServletRequest) {
            String header = httpServletRequest.getHeader(key);
            if (!StringHandler.empty(header)) {
                result = header;
            }
            String parameter = httpServletRequest.getParameter(key);
            if (!StringHandler.empty(parameter)) {
                result = parameter;
            }
        }

        return result;
    }

    /**
     * 获取值
     *
     * @param httpServletRequest 请求
     * @param key                键
     * @return 值
     */
    public static String getValue(HttpServletRequest httpServletRequest, String key) {
        return getValue(httpServletRequest, key, null);
    }

    /**
     * 获取格式化器
     *
     * @param httpServletRequest 请求
     * @return 值
     */
    public static String getFormatter(HttpServletRequest httpServletRequest) {
        return getValue(httpServletRequest, ControllerVariate.getFormatterHeader(), ControllerConstant.DEFAULT_FORMATTER);
    }
}
