package phature.amaranth.simple.framework.controller.securer;

import javax.servlet.http.HttpServletRequest;

/**
 * 安全器接口
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-21
 */
public interface Securer {
    /**
     * 验证
     *
     * @param httpServletRequest 请求
     * @return 结果
     */
    boolean authentication(HttpServletRequest httpServletRequest);
}
