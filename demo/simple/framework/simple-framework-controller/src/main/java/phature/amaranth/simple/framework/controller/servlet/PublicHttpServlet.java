package phature.amaranth.simple.framework.controller.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.controller.configuration.ControllerConfiguration;
import phature.amaranth.simple.framework.controller.entity.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 公共HTTP服务类
 *
 * @author phature@qq.com
 * @date 2020-12-16
 * @date 2020-12-21
 */
public class PublicHttpServlet extends AbstractControllerHttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(PrivateHttpServlet.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected boolean authentication(HttpServletRequest httpServletRequest, String securerClass) {
        return true;
    }

    @Override
    protected Map<String, Controller> getControllers(ControllerConfiguration controllerConfiguration) {
        return controllerConfiguration.getPublicControllers();
    }
}
