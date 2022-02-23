package phature.amaranth.simple.framework.controller.securer;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认安全器类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-21
 */
public class DefaultSecurer implements Securer {
    @Override
    public boolean authentication(HttpServletRequest httpServletRequest) {
        return true;
    }
}
