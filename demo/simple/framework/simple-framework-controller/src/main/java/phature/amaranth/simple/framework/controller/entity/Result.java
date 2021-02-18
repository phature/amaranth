package phature.amaranth.simple.framework.controller.entity;

/**
 * 结果类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-14
 */
public class Result {
    private int error;
    private Object value;

    /**
     * 获取错误
     *
     * @return 错误
     */
    public int getError() {
        return error;
    }

    /**
     * 设置错误
     *
     * @param error 错误
     */
    public void setError(int error) {
        this.error = error;
    }

    /**
     * 获取值
     *
     * @return 值
     */
    public Object getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
