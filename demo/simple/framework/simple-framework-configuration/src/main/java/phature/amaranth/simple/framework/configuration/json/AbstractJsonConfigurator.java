package phature.amaranth.simple.framework.configuration.json;

import phature.amaranth.simple.framework.configuration.AbstractConfigurator;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.exchange.JsonExchanger;

/**
 * JSON配置器抽象类
 *
 * @param <ConfigurationClass> 配置类
 * @author phature@qq.com
 * @date 2020-12-04
 * @date 2020-12-15
 */
public abstract class AbstractJsonConfigurator<ConfigurationClass> extends AbstractConfigurator<ConfigurationClass> {
    /**
     * 输入
     *
     * @return JSON字符串
     */
    protected abstract String in();

    /**
     * 输出
     *
     * @param json JSON字符串
     */
    protected abstract void out(String json);

    /**
     * 序列化
     *
     * @param value 值
     * @return JSON字符串
     */
    protected String serialize(ConfigurationClass value) {
        String result;

        JsonExchanger jsonExchanger = new JsonExchanger(ConfigurationVariate.getDateFormat());
        result = jsonExchanger.serialize(getConfigurationClass(), value);

        return result;
    }

    /**
     * 反序列化
     *
     * @param json JSON字符串
     * @return 值
     */
    protected ConfigurationClass deserialize(String json) {
        ConfigurationClass result;

        JsonExchanger jsonExchanger = new JsonExchanger(ConfigurationVariate.getDateFormat());
        result = jsonExchanger.deserialize(getConfigurationClass(), json);

        return result;
    }

    @Override
    public void read() {
        String json = in();
        ConfigurationClass value = deserialize(json);
        setConfiguration(value);
    }

    @Override
    public void write() {
        ConfigurationClass value = getConfiguration();
        String json = serialize(value);
        out(json);
    }
}
