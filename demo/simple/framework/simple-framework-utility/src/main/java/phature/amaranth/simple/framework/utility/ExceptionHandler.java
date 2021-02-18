package phature.amaranth.simple.framework.utility;

import java.util.ArrayList;
import java.util.List;

/**
 * 异常处理器类
 *
 * @author phature@qq.com
 * @date 2020-12-19
 * @date 2020-12-19
 */
public class ExceptionHandler {
    /**
     * 追溯
     *
     * @param throwable 异常
     * @return 结果
     */
    public static List<StackTraceElement> trace(Throwable throwable) {
        List<StackTraceElement> results = new ArrayList<>();

        if (null != throwable) {
            StackTraceElement[] stackTraceElements = throwable.getStackTrace();
            if (null != stackTraceElements) {
                for (StackTraceElement stackTraceElement : stackTraceElements) {
                    if (null != stackTraceElement) {
                        results.add(stackTraceElement);
                    }
                }
            }
            Throwable[] troubles = throwable.getSuppressed();
            if (null != troubles) {
                for (Throwable trouble : troubles) {
                    results.addAll(trace(trouble));
                }
            }
            Throwable cause = throwable.getCause();
            results.addAll(trace(cause));
        }

        return results;
    }
}
