package phature.amaranth.simple.framework.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.ConfigurationConstant;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 默认HTTP服务类
 *
 * @author phature@qq.com
 * @date 2020-12-08
 * @date 2020-12-11
 */
public class DefaultHttpServlet extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(DefaultHttpServlet.class);

    /**
     * 流程
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     */
    protected void flow(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setCharacterEncoding(ConfigurationConstant.Encoding.UTF8);
        httpServletResponse.setContentType(ConfigurationConstant.Mime.TEXT_HTML);

        try (PrintWriter printWriter = httpServletResponse.getWriter()) {
            printWriter.println("<!DOCTYPE HTML>");
            printWriter.println("<html>");
            printWriter.println("  <head>");
            printWriter.println("    <title>amaranth</title>");
            printWriter.println("  </head>");
            printWriter.println("  <body>");
            printWriter.println("    <h1 style=\"width:100%;text-align:center\">amaranth</h1>");
            printWriter.println("  </body>");
            printWriter.println("</html>");
        } catch (IOException exception) {
            logger.error(exception.getMessage(), exception);
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        flow(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        flow(httpServletRequest, httpServletResponse);
    }
}