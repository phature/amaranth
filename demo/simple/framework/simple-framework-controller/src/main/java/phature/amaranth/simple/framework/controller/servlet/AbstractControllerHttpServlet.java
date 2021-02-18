package phature.amaranth.simple.framework.controller.servlet;

import org.slf4j.Logger;
import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.controller.ControllerConstant;
import phature.amaranth.simple.framework.controller.ControllerVariate;
import phature.amaranth.simple.framework.controller.annotation.Name;
import phature.amaranth.simple.framework.controller.configuration.ControllerConfiguration;
import phature.amaranth.simple.framework.controller.entity.Controller;
import phature.amaranth.simple.framework.controller.entity.Trace;
import phature.amaranth.simple.framework.controller.formatter.Formatter;
import phature.amaranth.simple.framework.controller.formatter.JsonFormatter;
import phature.amaranth.simple.framework.controller.tracer.TraceThreadFactory;
import phature.amaranth.simple.framework.controller.tracer.Tracer;
import phature.amaranth.simple.framework.controller.utility.ParameterHandler;
import phature.amaranth.simple.framework.controller.utility.RequestHandler;
import phature.amaranth.simple.framework.controller.utility.ResponseHandler;
import phature.amaranth.simple.framework.controller.variate.ErrorVariate;
import phature.amaranth.simple.framework.controller.variate.Variate;
import phature.amaranth.simple.framework.ioc.Inject;
import phature.amaranth.simple.framework.utility.StringHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 控制器HTTP服务抽象类
 *
 * @author phature@qq.com
 * @date 2020-12-12
 * @date 2020-12-21
 */
public abstract class AbstractControllerHttpServlet extends HttpServlet {
    private final static ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), new TraceThreadFactory());
    private final ErrorVariate errorVariate = new ErrorVariate();

    /**
     * 获取日志器
     *
     * @return 日志器
     */
    protected abstract Logger getLogger();

    /**
     * 验证
     *
     * @param httpServletRequest 请求
     * @param securerClass       安全器类
     * @return 结果
     */
    protected abstract boolean authentication(HttpServletRequest httpServletRequest, String securerClass);

    /**
     * 获取控制器集合
     *
     * @param controllerConfiguration 控制器集合
     * @return 结果
     */
    protected abstract Map<String, Controller> getControllers(ControllerConfiguration controllerConfiguration);

    protected void threadTrace(Tracer tracer, Trace trace) {
        if (null != tracer && null != trace) {
            tracer.setTrace(trace);
            THREAD_POOL_EXECUTOR.execute(tracer);
        }
    }

    /**
     * 获取变量集合
     *
     * @param variateClasses 变量类集合
     * @return 结果
     */
    protected List<Variate<?>> getVariates(List<String> variateClasses) {
        List<Variate<?>> results = null;

        if (null != variateClasses) {
            results = new ArrayList<>();
            for (String variateClass : variateClasses) {
                Variate<?> variate = Inject.instance(Variate.class, variateClass);
                if (null != variate) {
                    results.add(variate);
                }
            }
        }
        return results;
    }

    /**
     * 获取追溯器
     *
     * @param tracerClass 追溯器类
     * @return 结果
     */
    protected Tracer getTracer(String tracerClass) {
        Tracer result = null;

        if (!StringHandler.empty(tracerClass)) {
            result = Inject.instance(Tracer.class, tracerClass);
        }

        return result;
    }

    /**
     * 获取编码
     *
     * @param encoding 编码
     * @return 结果
     */
    protected String getEncoding(String encoding) {
        String result = ConfigurationConstant.Encoding.UTF8;

        if (!StringHandler.empty(encoding)) {
            result = encoding;
        }

        return result;
    }

    /**
     * 获取格式化器
     *
     * @param formatterClasses   格式化器类集合
     * @param httpServletRequest 请求
     * @return 结果
     */
    protected Formatter getFormatter(Map<String, String> formatterClasses, HttpServletRequest httpServletRequest) {
        Formatter result = new JsonFormatter();

        if (null != formatterClasses) {
            String key = RequestHandler.getFormatter(httpServletRequest);
            if (formatterClasses.containsKey(key)) {
                String formatterClass = formatterClasses.get(key);
                if (!StringHandler.empty(formatterClass)) {
                    Formatter formatter = Inject.singleton(Formatter.class, formatterClass);
                    if (null != formatter) {
                        result = formatter;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 获取控制器
     *
     * @param servlet     服务
     * @param controllers 控制器集合
     * @return 结果
     */
    protected Controller getController(String servlet, Map<String, Controller> controllers) {
        Controller result = null;

        if (null != controllers && controllers.containsKey(servlet)) {
            result = controllers.get(servlet);
        } else {
            errorVariate.setValue(ControllerConstant.Error.CONTROLLER);
        }

        return result;
    }

    /**
     * 获取实例
     *
     * @param controller 控制器
     * @return 结果
     */
    protected Object getInstance(Controller controller) {
        Object result = null;

        if (!StringHandler.empty(controller.getClassName())) {
            result = Inject.instance(Object.class, controller.getClassName());
        }

        return result;
    }

    /**
     * 获取方法
     *
     * @param instance   实例
     * @param controller 控制器
     * @return 结果
     */
    protected Method getMethod(Object instance, Controller controller) {
        Method result = null;

        Class<?> instanceClass = instance.getClass();
        for (Method method : instanceClass.getDeclaredMethods()) {
            if (method.getName().equals(controller.getMethodName())) {
                result = method;
                break;
            }
        }

        return result;
    }

    /**
     * 获取参数集合
     *
     * @param method              方法
     * @param body                身体
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @return 结果
     */
    protected Object[] getParameters(Method method, String body, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Object[] results = null;

        Parameter[] parameters = method.getParameters();
        if (null != parameters) {
            results = new Object[parameters.length];
            Name annotationName;
            Parameter parameter;
            Class<?> parameterClass;
            String parameterName;
            String parameterValue;
            for (int i = 0; i < parameters.length; i++) {
                parameter = parameters[i];
                parameterClass = parameter.getType();
                if (parameterClass.equals(HttpServletRequest.class)) {
                    results[i] = httpServletRequest;
                } else if (parameterClass.equals(HttpServletResponse.class)) {
                    results[i] = httpServletResponse;
                } else {
                    annotationName = parameter.getAnnotation(Name.class);
                    parameterName = null == annotationName ? null : annotationName.value();
                    if (StringHandler.empty(parameterName)) {
                        parameterValue = body;
                    } else {
                        parameterValue = RequestHandler.getValue(httpServletRequest, parameterName);
                    }
                    results[i] = ParameterHandler.parse(parameterClass, parameterValue);
                }
            }
        }

        return results;
    }

    /**
     * 流程
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     */
    protected void flow(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        List<Variate<?>> variates = null;
        Trace trace = new Trace();
        PrintWriter printWriter = null;
        Formatter formatter = new JsonFormatter();
        Object result = null;
        String content;

        try {
            printWriter = httpServletResponse.getWriter();
            errorVariate.setValue(ControllerConstant.Error.NONE);
            trace.assignment(httpServletRequest);

            ControllerConfiguration controllerConfiguration = ControllerVariate.getControllerConfiguration();
            if (null != controllerConfiguration) {
                variates = getVariates(controllerConfiguration.getVariateClasses());
                Tracer beginTracer = getTracer(controllerConfiguration.getBeginTracerClass());
                threadTrace(beginTracer, trace);

                formatter = getFormatter(controllerConfiguration.getFormatterClasses(), httpServletRequest);
                String encoding = getEncoding(controllerConfiguration.getEncoding());
                String mimeType = formatter.getMimeType();
                httpServletResponse.setCharacterEncoding(encoding);
                httpServletResponse.setContentType(mimeType);

                String securerClass = controllerConfiguration.getSecurerClass();

                if (authentication(httpServletRequest, securerClass)) {
                    String servlet = httpServletRequest.getServletPath();
                    Map<String, Controller> controllers = getControllers(controllerConfiguration);
                    Controller controller = getController(servlet, controllers);
                    if (null == controller) {
                        errorVariate.setValue(ControllerConstant.Error.CONTROLLER);
                    } else {
                        trace.setController(controller);
                        Object instance = getInstance(controller);
                        if (null == instance) {
                            errorVariate.setValue(ControllerConstant.Error.CLASS);
                        } else {
                            Method method = getMethod(instance, controller);
                            if (null == method) {
                                errorVariate.setValue(ControllerConstant.Error.METHOD);
                            } else {
                                Object[] parameters = getParameters(method, trace.getBody(), httpServletRequest, httpServletResponse);
                                result = method.invoke(instance, parameters);
                            }
                        }
                    }
                } else {
                    errorVariate.setValue(ControllerConstant.Error.SECURITY);
                }

                trace.setEnd(new Date());
                Tracer endTracer = getTracer(controllerConfiguration.getEndTracerClass());
                threadTrace(endTracer, trace);
            } else {
                errorVariate.setValue(ControllerConstant.Error.CONFIGURATION);
            }
            content = formatter.format(errorVariate.getValue(), result);
            printWriter.println(content);
        } catch (Exception exception) {
            errorVariate.setValue(ControllerConstant.Error.EXCEPTION);
            if (null != printWriter) {
                content = formatter.format(exception);
                printWriter.println(content);
            }
            getLogger().error(exception.getMessage(), exception);
        } finally {
            if (null != variates) {
                for (Variate<?> variate : variates) {
                    variate.destroy();
                }
            }
            ResponseHandler.setError(httpServletResponse, errorVariate.getValue());
            if (null != printWriter) {
                printWriter.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        flow(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        flow(httpServletRequest, httpServletResponse);
    }
}