package phature.amaranth.simple.framework.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 默认HTTP会话监听器类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-08
 */
public class DefaultHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
    }
}
