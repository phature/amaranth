package phature.amaranth.simple.framework.controller.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.controller.configuration.ControllerConfiguration;
import phature.amaranth.simple.framework.controller.entity.Controller;
import phature.amaranth.simple.framework.controller.securer.Securer;
import phature.amaranth.simple.framework.ioc.Inject;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 私有HTTP服务类
 *
 * @author phature@qq.com
 * @date 2020-12-16
 * @date 2020-12-21
 */
public class PrivateHttpServlet extends AbstractControllerHttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(PrivateHttpServlet.class);

    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    protected boolean authentication(HttpServletRequest httpServletRequest, String securerClass) {
        boolean result = false;

        if (!StringHandler.empty(securerClass)) {
            Securer securer = Inject.instance(Securer.class, securerClass);

            result = null == securer || securer.authentication(httpServletRequest);
        }

        return result;
    }

    @Override
    protected Map<String, Controller> getControllers(ControllerConfiguration controllerConfiguration) {
        return controllerConfiguration.getPrivateControllers();
    }
}
