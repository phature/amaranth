package phature.amaranth.simple.framework.utility;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 时间处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-19
 * @date 2020-12-19
 */
public class TimeHandler {
    /**
     * 获取即时
     *
     * @param value 时间
     * @return 结果
     */
    public static Instant instant(Date value) {
        Instant result = null;

        if (null != value) {
            result = value.toInstant();
        }

        return result;
    }

    /**
     * 获取即时
     *
     * @param value 本地时间
     * @return 结果
     */
    public static Instant instant(LocalDateTime value) {
        Instant result = null;

        if (null != value) {
            result = value.atZone(ZoneId.systemDefault()).toInstant();
        }

        return result;
    }

    /**
     * 获取本地时间
     *
     * @param value 时间
     * @return 结果
     */
    public static LocalDateTime localDateTime(Date value) {
        LocalDateTime result = null;

        if (null != value) {
            result = value.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        return result;
    }

    /**
     * 获取本地时间
     *
     * @param value 即时
     * @return 结果
     */
    public static LocalDateTime localDateTime(Instant value) {
        LocalDateTime result = null;

        if (null != value) {
            result = value.atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        return result;
    }

    /**
     * 获取时间
     *
     * @param value 即时
     * @return 结果
     */
    public static Date date(Instant value) {
        Date result = null;

        if (null != value) {
            result = Date.from(value);
        }

        return result;
    }

    /**
     * 获取时间
     *
     * @param value 本地时间
     * @return 结果
     */
    public static Date date(LocalDateTime value) {
        Date result = null;

        if (null != value) {
            result = Date.from(value.atZone(ZoneId.systemDefault()).toInstant());
        }

        return result;
    }
}
