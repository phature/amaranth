package phature.amaranth.simple.framework.controller.variate;

/**
 * 错误变量类
 *
 * @author phature@qq.com
 * @date 2020-12-17
 * @date 2020-12-17
 */
public class ErrorVariate implements Variate<Integer> {
    private final static ThreadLocal<Integer> THREAD_LOCAL = new InheritableThreadLocal<>();

    @Override
    public Integer getValue() {
        return THREAD_LOCAL.get();
    }

    @Override
    public void setValue(Integer value) {
        THREAD_LOCAL.set(value);
    }

    @Override
    public void destroy() {
        THREAD_LOCAL.remove();
    }
}
