package phature.amaranth.simple.framework.controller;

import phature.amaranth.simple.framework.controller.configuration.ControllerConfiguration;

/**
 * 控制器变量类
 *
 * @author phature@qq.com
 * @date 2020-12-12
 * @date 2020-12-21
 */
public class ControllerVariate {
    private static String formatterHeader = ControllerConstant.Header.FORMATTER;
    private static String errorHeader = ControllerConstant.Header.ERROR;
    private static ControllerConfiguration controllerConfiguration;

    /**
     * 获取格式化器头
     *
     * @return 格式化器头
     */
    public static String getFormatterHeader() {
        return formatterHeader;
    }

    /**
     * 设置格式化器头
     *
     * @param formatterHeader 格式化器头
     */
    public static void setFormatterHeader(String formatterHeader) {
        ControllerVariate.formatterHeader = formatterHeader;
    }

    /**
     * 获取错误头
     *
     * @return 错误头
     */
    public static String getErrorHeader() {
        return errorHeader;
    }

    /**
     * 设置错误头
     *
     * @param errorHeader 错误头
     */
    public static void setErrorHeader(String errorHeader) {
        ControllerVariate.errorHeader = errorHeader;
    }

    /**
     * 获取控制器配置
     *
     * @return 控制器配置
     */
    public static ControllerConfiguration getControllerConfiguration() {
        return controllerConfiguration;
    }

    /**
     * 设置控制器配置
     *
     * @param controllerConfiguration 控制器配置
     */
    public static void setControllerConfiguration(ControllerConfiguration controllerConfiguration) {
        ControllerVariate.controllerConfiguration = controllerConfiguration;
    }
}
