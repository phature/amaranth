package phature.amaranth.simple.framework.controller.tracer;

import phature.amaranth.simple.framework.controller.entity.Trace;

/**
 * 追溯器接口
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-14
 */
public interface Tracer extends Runnable {
    /**
     * 获取追溯
     *
     * @return 追溯
     */
    Trace getTrace();

    /**
     * 设置追溯
     *
     * @param trace 追溯
     */
    void setTrace(Trace trace);
}
