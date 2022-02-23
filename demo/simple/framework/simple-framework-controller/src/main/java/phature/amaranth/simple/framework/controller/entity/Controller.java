package phature.amaranth.simple.framework.controller.entity;

/**
 * 控制器类
 *
 * @author phature@qq.com
 * @date 2020-12-15
 * @date 2020-12-16
 */
public class Controller {
    private String className;
    private String methodName;

    /**
     * 获取类名称
     *
     * @return 类名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置类名称
     *
     * @param className 类名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取方法名称
     *
     * @return 方法名称
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置方法名称
     *
     * @param methodName 方法名称
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
