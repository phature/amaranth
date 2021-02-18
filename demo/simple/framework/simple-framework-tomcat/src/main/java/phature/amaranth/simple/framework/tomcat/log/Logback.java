package phature.amaranth.simple.framework.tomcat.log;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志器类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-15
 */
public class Logback implements Log {
    private static Logger logger;

    /**
     * 构造函数
     */
    public Logback() {
        logger = LoggerFactory.getLogger(Logback.class);
    }

    /**
     * 构造函数
     *
     * @param name 名字
     */
    public Logback(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void trace(Object message) {
        trace(message, null);
    }

    @Override
    public void trace(Object message, Throwable throwable) {
        if (null != message && message instanceof String) {
            logger.trace((String) message, throwable);
        } else {
            logger.trace(null, throwable);
        }
    }

    @Override
    public void debug(Object message) {
        debug(message, null);
    }

    @Override
    public void debug(Object message, Throwable throwable) {
        if (null != message && message instanceof String) {
            logger.debug((String) message, throwable);
        } else {
            logger.debug(null, throwable);
        }
    }

    @Override
    public void info(Object message) {
        info(message, null);
    }

    @Override
    public void info(Object message, Throwable throwable) {
        if (null != message && message instanceof String) {
            logger.info((String) message, throwable);
        } else {
            logger.info(null, throwable);
        }
    }

    @Override
    public void warn(Object message) {
        warn(message, null);
    }

    @Override
    public void warn(Object message, Throwable throwable) {
        if (null != message && message instanceof String) {
            logger.warn((String) message, throwable);
        } else {
            logger.warn(null, throwable);
        }
    }

    @Override
    public void error(Object message) {
        error(message, null);
    }

    @Override
    public void error(Object message, Throwable throwable) {
        if (null != message && message instanceof String) {
            logger.error((String) message, throwable);
        } else {
            logger.error(null, throwable);
        }
    }

    @Override
    public void fatal(Object message) {
        error(message, null);
    }

    @Override
    public void fatal(Object message, Throwable throwable) {
        error(message, throwable);
    }
}