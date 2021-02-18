package phature.amaranth.simple.framework.utility.exchange;

/**
 * 交换器接口
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-17
 */
public interface Exchanger {
    /**
     * 序列化
     *
     * @param valueClass 值类型
     * @param value      值
     * @param <Value>    值类
     * @return 文本
     */
    <Value> String serialize(Class<Value> valueClass, Value value);

    /**
     * 反序列化
     *
     * @param valueClass 值类型
     * @param text       文本
     * @param <Value>    值类
     * @return 值
     */
    <Value> Value deserialize(Class<Value> valueClass, String text);
}
