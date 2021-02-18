package phature.amaranth.simple.framework.controller.formatter;

/**
 * 格式化器接口
 *
 * @author phature@qq.com
 * @date 2020-12-17
 * @date 2020-12-17
 */
public interface Formatter {
    /**
     * 获取媒体类型
     *
     * @return 媒体类型
     */
    String getMimeType();

    /**
     * 格式化
     *
     * @param error 错误
     * @param value 结果
     * @return 结果
     */
    String format(Integer error, Object value);

    /**
     * 格式化
     *
     * @param exception 异常
     * @return 结果
     */
    String format(Exception exception);
}
