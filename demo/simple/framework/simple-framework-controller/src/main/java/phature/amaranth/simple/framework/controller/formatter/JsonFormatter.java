package phature.amaranth.simple.framework.controller.formatter;

import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.controller.ControllerConstant;
import phature.amaranth.simple.framework.controller.entity.Result;
import phature.amaranth.simple.framework.utility.ExceptionHandler;
import phature.amaranth.simple.framework.utility.exchange.JsonExchanger;

/**
 * JSON格式化器类
 *
 * @author phature@qq.com
 * @date 2020-12-17
 * @date 2020-12-19
 */
public class JsonFormatter implements Formatter {
    private final JsonExchanger jsonExchanger = new JsonExchanger(ConfigurationVariate.getDateFormat());

    @Override
    public String getMimeType() {
        return ConfigurationConstant.Mime.APPLICATION_JSON;
    }

    /**
     * 格式化
     *
     * @param result 结果
     * @return 结果
     */
    protected String format(Result result) {
        return jsonExchanger.serialize(Result.class, result);
    }

    @Override
    public String format(Integer error, Object value) {
        Result result = new Result();
        result.setError(null == error ? ControllerConstant.Error.NONE : error);
        result.setValue(value);
        return format(result);
    }

    @Override
    public String format(Exception exception) {
        Result result = new Result();
        result.setError(ControllerConstant.Error.EXCEPTION);
        result.setValue(ExceptionHandler.trace(exception));
        return format(result);
    }
}
