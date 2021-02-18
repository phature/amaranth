package phature.amaranth.simple.framework.controller;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.controller.annotation.Name;
import phature.amaranth.simple.framework.controller.variate.ErrorVariate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认控制器类
 *
 * @author phature@qq.com
 * @date 2020-12-15
 * @date 2020-12-18
 */
public class DefaultController {
    private final ErrorVariate errorVariate = new ErrorVariate();

    /**
     * 空
     */
    public void empty() {
    }

    /**
     * 执行
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @param parameter           参数
     * @param value               值
     * @return 结果
     */
    public Map<String, String> execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @Name String parameter, @Name("value") Date value) {
        Map<String, String> results = new HashMap<>(ConfigurationConstant.Map.TINY_INITIAL_CAPACITY);

        results.put("request", httpServletRequest.getClass().getName());
        results.put("response", httpServletResponse.getClass().getName());
        results.put("parameter", parameter);
        if (null != value) {
            results.put("value", ConfigurationVariate.getDateFormat().format(value));
        }

        return results;
    }

    /**
     * 错误
     */
    public void error() {
        errorVariate.setValue(ControllerConstant.Error.PARAMETER);
    }
}
