package phature.amaranth.simple.framework.controller.tracer;

import java.util.concurrent.ThreadFactory;

/**
 * 追溯器线程工厂类
 *
 * @author phature@qq.com
 * @date 2020-12-16
 * @date 2020-12-16
 */
public class TraceThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable);
    }
}
