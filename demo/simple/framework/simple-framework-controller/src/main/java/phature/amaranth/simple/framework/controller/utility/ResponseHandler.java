package phature.amaranth.simple.framework.controller.utility;

import phature.amaranth.simple.framework.controller.ControllerVariate;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * 响应处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-17
 * @date 2020-12-17
 */
public class ResponseHandler {
    /**
     * 设置头
     *
     * @param httpServletResponse 响应
     * @param key                 键
     * @param value               值
     */
    public static void setHeader(HttpServletResponse httpServletResponse, String key, String value) {
        if (null != httpServletResponse && !StringHandler.empty(key)) {
            httpServletResponse.setHeader(key, value);
        }
    }

    /**
     * 设置错误
     *
     * @param httpServletResponse 响应
     * @param value               值
     */
    public static void setError(HttpServletResponse httpServletResponse, Integer value) {
        if (null != httpServletResponse && null != value) {
            setHeader(httpServletResponse, ControllerVariate.getErrorHeader(), value.toString());
        }
    }
}
