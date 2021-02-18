package phature.amaranth.simple.framework.controller.utility;

import phature.amaranth.simple.framework.configuration.ConfigurationVariate;
import phature.amaranth.simple.framework.utility.TypeHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 参数处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-18
 * @date 2020-12-19
 */
public class ParameterHandler {
    /**
     * 转换
     *
     * @param valueClass 值类
     * @param value      值
     * @return 结果
     */
    public static Object parse(Class<?> valueClass, String value) {
        Object result;

        if (byte.class.equals(valueClass)) {
            result = TypeHandler.getByte(value);
        } else if (short.class.equals(valueClass)) {
            result = TypeHandler.getShort(value);
        } else if (int.class.equals(valueClass)) {
            result = TypeHandler.getInteger(value);
        } else if (long.class.equals(valueClass)) {
            result = TypeHandler.getLong(value);
        } else if (float.class.equals(valueClass)) {
            result = TypeHandler.getFloat(value);
        } else if (double.class.equals(valueClass)) {
            result = TypeHandler.getDouble(value);
        } else if (boolean.class.equals(valueClass)) {
            result = TypeHandler.getBoolean(value);
        } else if (char.class.equals(valueClass)) {
            result = TypeHandler.getCharacter(value);
        } else if (Byte.class.equals(valueClass)) {
            result = TypeHandler.getByte(value, null);
        } else if (Short.class.equals(valueClass)) {
            result = TypeHandler.getShort(value, null);
        } else if (Integer.class.equals(valueClass)) {
            result = TypeHandler.getInteger(value, null);
        } else if (Long.class.equals(valueClass)) {
            result = TypeHandler.getLong(value, null);
        } else if (Float.class.equals(valueClass)) {
            result = TypeHandler.getFloat(value, null);
        } else if (Double.class.equals(valueClass)) {
            result = TypeHandler.getDouble(value, null);
        } else if (Boolean.class.equals(valueClass)) {
            result = TypeHandler.getBoolean(value, null);
        } else if (Character.class.equals(valueClass)) {
            result = TypeHandler.getByte(value, null);
        } else if (Instant.class.equals(valueClass)) {
            result = TypeHandler.getInstant(value, ConfigurationVariate.getDateTimeFormatter());
        } else if (LocalDateTime.class.equals(valueClass)) {
            result = TypeHandler.getLocalDateTime(value, ConfigurationVariate.getDateTimeFormatter());
        } else if (Date.class.equals(valueClass)) {
            result = TypeHandler.getDate(value, ConfigurationVariate.getDateTimeFormatter());
        } else if (String.class.equals(valueClass)) {
            result = value;
        } else {
            result = TypeHandler.getObject(valueClass, value, ConfigurationVariate.getDateFormat());
        }

        return result;
    }
}
