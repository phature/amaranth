package phature.amaranth.simple.framework.utility;

import phature.amaranth.simple.framework.utility.exchange.JsonExchanger;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 类型处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-19
 * @date 2020-12-19
 */
public class TypeHandler {
    /**
     * 获取字节
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Byte getByte(String value, Byte defaultValue) {
        Byte result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Byte.parseByte(value);
        }

        return result;
    }

    /**
     * 获取字节
     *
     * @param value 值
     * @return 结果
     */
    public static byte getByte(String value) {
        Byte defaultValue = 0;
        return getByte(value, defaultValue);
    }

    /**
     * 获取短整数
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Short getShort(String value, Short defaultValue) {
        Short result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Short.parseShort(value);
        }

        return result;
    }

    /**
     * 获取短整数
     *
     * @param value 值
     * @return 结果
     */
    public static short getShort(String value) {
        Short defaultValue = 0;
        return getShort(value, defaultValue);
    }

    /**
     * 获取整数
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Integer getInteger(String value, Integer defaultValue) {
        Integer result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Integer.parseInt(value);
        }

        return result;
    }

    /**
     * 获取整数
     *
     * @param value 值
     * @return 结果
     */
    public static int getInteger(String value) {
        Integer defaultValue = 0;
        return getInteger(value, defaultValue);
    }

    /**
     * 获取长整数
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Long getLong(String value, Long defaultValue) {
        Long result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Long.parseLong(value);
        }

        return result;
    }

    /**
     * 获取长整数
     *
     * @param value 值
     * @return 结果
     */
    public static long getLong(String value) {
        Long defaultValue = 0L;
        return getLong(value, defaultValue);
    }

    /**
     * 获取单精度浮点数
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Float getFloat(String value, Float defaultValue) {
        Float result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Float.parseFloat(value);
        }

        return result;
    }

    /**
     * 获取单精度浮点数
     *
     * @param value 值
     * @return 结果
     */
    public static float getFloat(String value) {
        Float defaultValue = 0F;
        return getFloat(value, defaultValue);
    }

    /**
     * 获取双精度浮点数
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Double getDouble(String value, Double defaultValue) {
        Double result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Double.parseDouble(value);
        }

        return result;
    }

    /**
     * 获取双精度浮点数
     *
     * @param value 值
     * @return 结果
     */
    public static double getDouble(String value) {
        Double defaultValue = 0D;
        return getDouble(value, defaultValue);
    }

    /**
     * 获取布尔值
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Boolean getBoolean(String value, Boolean defaultValue) {
        Boolean result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = Boolean.parseBoolean(value);
        }

        return result;
    }

    /**
     * 获取布尔值
     *
     * @param value 值
     * @return 结果
     */
    public static boolean getBoolean(String value) {
        return getBoolean(value, Boolean.FALSE);
    }

    /**
     * 获取字符
     *
     * @param value        值
     * @param defaultValue 默认值
     * @return 结果
     */
    public static Character getCharacter(String value, Character defaultValue) {
        Character result = defaultValue;

        if (!StringHandler.empty(value)) {
            result = value.charAt(0);
        }

        return result;
    }

    /**
     * 获取字符
     *
     * @param value 值
     * @return 结果
     */
    public static char getCharacter(String value) {
        return getCharacter(value, Character.MIN_VALUE);
    }

    /**
     * 获取即时
     *
     * @param value             值
     * @param dateTimeFormatter 时间格式化器
     * @return 结果
     */
    public static Instant getInstant(String value, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime localDateTime = getLocalDateTime(value, dateTimeFormatter);

        return TimeHandler.instant(localDateTime);
    }

    /**
     * 获取本地时间
     *
     * @param value             值
     * @param dateTimeFormatter 时间格式化器
     * @return 结果
     */
    public static LocalDateTime getLocalDateTime(String value, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime result = null;

        if (!StringHandler.empty(value)) {
            result = LocalDateTime.parse(value, dateTimeFormatter);
        }

        return result;
    }

    /**
     * 获取时间
     *
     * @param value             值
     * @param dateTimeFormatter 时间格式化器
     * @return 结果
     */
    public static Date getDate(String value, DateTimeFormatter dateTimeFormatter) {
        LocalDateTime localDateTime = getLocalDateTime(value, dateTimeFormatter);

        return TimeHandler.date(localDateTime);
    }

    /**
     * 获取对象
     *
     * @param valueClass 值类
     * @param value      值
     * @param dateFormat 时间格式
     * @return 结果
     */
    public static Object getObject(Class<?> valueClass, String value, DateFormat dateFormat) {
        Object result;

        JsonExchanger jsonExchanger = new JsonExchanger(dateFormat);
        result = jsonExchanger.deserialize(valueClass, value);

        return result;
    }
}
