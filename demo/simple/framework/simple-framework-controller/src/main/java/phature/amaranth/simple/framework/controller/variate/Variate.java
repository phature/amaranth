package phature.amaranth.simple.framework.controller.variate;

/**
 * 变量接口
 *
 * @param <Value> 值类
 * @author phature@qq.com
 * @date 2020-12-17
 * @date 2020-12-17
 */
public interface Variate<Value> {
    /**
     * 获取值
     *
     * @return 值
     */
    Value getValue();

    /**
     * 设置值
     *
     * @param value 值
     */
    void setValue(Value value);

    /**
     * 销毁
     */
    void destroy();
}
