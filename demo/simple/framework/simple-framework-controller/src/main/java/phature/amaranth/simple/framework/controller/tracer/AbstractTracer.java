package phature.amaranth.simple.framework.controller.tracer;

import phature.amaranth.simple.framework.controller.entity.Trace;

/**
 * 追溯器抽象类
 *
 * @author phature@qq.com
 * @date 2020-12-14
 * @date 2020-12-14
 */
public abstract class AbstractTracer implements Tracer {
    private Trace trace;

    @Override
    public Trace getTrace() {
        return trace;
    }

    @Override
    public void setTrace(Trace trace) {
        this.trace = trace;
    }
}
