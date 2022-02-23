package phature.amaranth.simple.framework.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import phature.amaranth.simple.framework.configuration.ConfigurationConstant;
import phature.amaranth.simple.framework.ioc.configuration.IocConfiguration;
import phature.amaranth.simple.framework.utility.StringHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注入类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-24
 */
public class Inject {
    private final static ConcurrentHashMap<String, Object> SINGLETONS = new ConcurrentHashMap<>(ConfigurationConstant.Map.MEDIUM_INITIAL_CAPACITY);
    private final static Logger logger = LoggerFactory.getLogger(Inject.class);

    /**
     * 获取默认实例
     *
     * @param interfaceClass 接口类
     * @return 结果
     */
    private static String getDefaultInstance(String interfaceClass) {
        String result = null;

        IocConfiguration iocConfiguration = IocVariate.getIocConfiguration();
        if (!StringHandler.empty(interfaceClass) && null != iocConfiguration) {
            Map<String, String> defaultInstances = iocConfiguration.getDefaultInstances();
            if (null != defaultInstances) {
                result = defaultInstances.get(interfaceClass);
            }
        }

        return result;
    }

    /**
     * 实例化
     *
     * @param interfaceClass 接口类
     * @param instanceClass  实例类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface instance(Class<Interface> interfaceClass, Class<?> instanceClass) {
        return IocVariate.getObjectFactory().instance(interfaceClass, instanceClass);
    }

    /**
     * 实例化
     *
     * @param interfaceClass 接口类
     * @param instanceClass  实例类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface instance(Class<Interface> interfaceClass, String instanceClass) {
        Interface result = null;

        if (!StringHandler.empty(instanceClass)) {
            try {
                Class<?> classType = Class.forName(instanceClass);
                result = instance(interfaceClass, classType);
            } catch (ClassNotFoundException exception) {
                logger.error(exception.getMessage(), exception);
            }
        }

        return result;
    }

    /**
     * 实例化
     *
     * @param interfaceClass 接口类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface instance(Class<Interface> interfaceClass) {
        Interface result = null;

        if (null != interfaceClass) {
            String interfaceType = interfaceClass.getName();
            String instanceClass = getDefaultInstance(interfaceType);
            result = instance(interfaceClass, instanceClass);
        }

        return result;
    }

    /**
     * 单例化
     *
     * @param interfaceClass 接口类
     * @param instanceClass  实例类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface singleton(Class<Interface> interfaceClass, Class<?> instanceClass) {
        Interface result = null;

        if (null != instanceClass) {
            result = singleton(interfaceClass, instanceClass.getName());
        }

        return result;
    }

    /**
     * 单例化
     *
     * @param interfaceClass 接口类
     * @param instanceClass  实例类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface singleton(Class<Interface> interfaceClass, String instanceClass) {
        Interface result;

        if (SINGLETONS.containsKey(instanceClass)) {
            result = (Interface) SINGLETONS.get(instanceClass);
        } else {
            result = instance(interfaceClass, instanceClass);
            if (null != result) {
                SINGLETONS.put(instanceClass, result);
            }
        }

        return result;
    }

    /**
     * 单例化
     *
     * @param interfaceClass 接口类
     * @param <Interface>    接口
     * @return 实例
     */
    public static <Interface> Interface singleton(Class<Interface> interfaceClass) {
        Interface result = null;

        if (null != interfaceClass) {
            String interfaceType = interfaceClass.getName();
            String instanceClass = getDefaultInstance(interfaceType);
            result = singleton(interfaceClass, instanceClass);
        }

        return result;
    }
}
