package phature.amaranth.simple.framework.controller.entity;

import org.apache.commons.io.IOUtils;
import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 追溯类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-15
 */
public class Trace {
    private String uuid;
    private String client;
    private String server;
    private String url;
    private Map<String, String> headers;
    private Map<String, String> parameters;
    private String body;
    private Controller controller;
    private Date begin;
    private Date end;

    /**
     * 获取编号
     *
     * @return 编号
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置编号
     *
     * @param uuid 编号
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取客户端
     *
     * @return 客户端
     */
    public String getClient() {
        return client;
    }

    /**
     * 设置客户端
     *
     * @param client 客户端
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * 获取服务器
     *
     * @return 服务器
     */
    public String getServer() {
        return server;
    }

    /**
     * 设置服务器
     *
     * @param server 服务器
     */
    public void setServer(String server) {
        this.server = server;
    }

    /**
     * 获取URL
     *
     * @return URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取头集合
     *
     * @return 头集合
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * 设置头集合
     *
     * @param headers 头集合
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * 获取参数集合
     *
     * @return 参数集合
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * 设置参数集合
     *
     * @param parameters 参数集合
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * 获取身体
     *
     * @return 身体
     */
    public String getBody() {
        return body;
    }

    /**
     * 设置身体
     *
     * @param body 身体
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 获取控制器
     *
     * @return 控制器
     */
    public Controller getController() {
        return controller;
    }

    /**
     * 设置控制器
     *
     * @param controller 控制器
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * 获取开始时间
     *
     * @return 开始时间
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * 设置开始时间
     *
     * @param begin 开始时间
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * 获取结束时间
     *
     * @return 结束时间
     */
    public Date getEnd() {
        return end;
    }

    /**
     * 设置结束时间
     *
     * @param end 结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * 构造器
     */
    public Trace() {
        this.setUuid(StringHandler.uuid());
        this.setBegin(new Date());
    }

    /**
     * 赋值
     *
     * @param httpServletRequest 请求
     * @throws IOException 读写异常
     */
    public void assignment(HttpServletRequest httpServletRequest) throws IOException {
        try (InputStream inputStream = httpServletRequest.getInputStream()) {
            this.setClient(httpServletRequest.getRemoteAddr());
            this.setServer(InetAddress.getLocalHost().getHostName());
            this.setUrl(httpServletRequest.getServletPath());
            this.setHeaders(new HashMap<>(ConfigurationConstant.Map.TINY_INITIAL_CAPACITY));
            this.setParameters(new HashMap<>(ConfigurationConstant.Map.TINY_INITIAL_CAPACITY));
            this.setBody(IOUtils.toString(inputStream));

            Enumeration<String> headerKeys = httpServletRequest.getHeaderNames();
            while (headerKeys.hasMoreElements()) {
                String headerKey = headerKeys.nextElement();
                String headerValue = httpServletRequest.getHeader(headerKey);
                this.headers.put(headerKey, headerValue);
            }

            Enumeration<String> parameterKeys = httpServletRequest.getParameterNames();
            while (parameterKeys.hasMoreElements()) {
                String parameterKey = parameterKeys.nextElement();
                String parameterValue = httpServletRequest.getParameter(parameterKey);
                this.parameters.put(parameterKey, parameterValue);
            }
        }
    }
}
