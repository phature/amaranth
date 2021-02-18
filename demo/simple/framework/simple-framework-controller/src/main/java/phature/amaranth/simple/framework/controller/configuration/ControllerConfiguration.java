package phature.amaranth.simple.framework.controller.configuration;

import phature.amaranth.simple.framework.controller.entity.Controller;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 控制器配置类
 *
 * @author phature@qq.com
 * @date 2020-12-12
 * @date 2020-12-17
 */
public class ControllerConfiguration {
    private Vector<String> variateClasses;
    private String beginTracerClass;
    private String endTracerClass;
    private String securerClass;
    private String encoding;
    private ConcurrentHashMap<String, String> formatterClasses;
    private ConcurrentHashMap<String, Controller> publicControllers;
    private ConcurrentHashMap<String, Controller> privateControllers;

    /**
     * 获取变量类集合
     *
     * @return 变量类集合
     */
    public Vector<String> getVariateClasses() {
        return variateClasses;
    }

    /**
     * 设置变量类集合
     *
     * @param variateClasses 变量类集合
     */
    public void setVariateClasses(Vector<String> variateClasses) {
        this.variateClasses = variateClasses;
    }

    /**
     * 获取开始追溯器类
     *
     * @return 开始追溯器类
     */
    public String getBeginTracerClass() {
        return beginTracerClass;
    }

    /**
     * 设置开始追溯器类
     *
     * @param beginTracerClass 开始追溯器类
     */
    public void setBeginTracerClass(String beginTracerClass) {
        this.beginTracerClass = beginTracerClass;
    }

    /**
     * 获取结束追溯器类
     *
     * @return 结束追溯器类
     */
    public String getEndTracerClass() {
        return endTracerClass;
    }

    /**
     * 设置结束追溯器类
     *
     * @param endTracerClass 结束追溯器类
     */
    public void setEndTracerClass(String endTracerClass) {
        this.endTracerClass = endTracerClass;
    }

    /**
     * 获取安全器类
     *
     * @return 安全器类
     */
    public String getSecurerClass() {
        return securerClass;
    }

    /**
     * 设置安全器类
     *
     * @param securerClass 安全器类
     */
    public void setSecurerClass(String securerClass) {
        this.securerClass = securerClass;
    }

    /**
     * 获取编码
     *
     * @return 编码
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * 设置编码
     *
     * @param encoding 编码
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * 获取格式化器类集合
     *
     * @return 格式化器类集合
     */
    public ConcurrentHashMap<String, String> getFormatterClasses() {
        return formatterClasses;
    }

    /**
     * 设置格式化器类集合
     *
     * @param formatterClasses 格式化器类集合
     */
    public void setFormatterClasses(ConcurrentHashMap<String, String> formatterClasses) {
        this.formatterClasses = formatterClasses;
    }

    /**
     * 获取公共控制器集合
     *
     * @return 公共控制器集合
     */
    public ConcurrentHashMap<String, Controller> getPublicControllers() {
        return publicControllers;
    }

    /**
     * 设置公共控制器集合
     *
     * @param publicControllers 公共控制器集合
     */
    public void setPublicControllers(ConcurrentHashMap<String, Controller> publicControllers) {
        this.publicControllers = publicControllers;
    }

    /**
     * 获取私有控制器集合
     *
     * @return 私有控制器集合
     */
    public ConcurrentHashMap<String, Controller> getPrivateControllers() {
        return privateControllers;
    }

    /**
     * 设置私有控制器集合
     *
     * @param privateControllers 私有控制器集合
     */
    public void setPrivateControllers(ConcurrentHashMap<String, Controller> privateControllers) {
        this.privateControllers = privateControllers;
    }
}
