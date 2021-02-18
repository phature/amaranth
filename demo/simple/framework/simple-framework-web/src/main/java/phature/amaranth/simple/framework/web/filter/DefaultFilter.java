package phature.amaranth.simple.framework.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 默认过滤器类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-08
 */
public class DefaultFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}