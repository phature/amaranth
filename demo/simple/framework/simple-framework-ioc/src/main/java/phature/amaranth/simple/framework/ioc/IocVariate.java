package phature.amaranth.simple.framework.ioc;

import phature.amaranth.simple.framework.ioc.configuration.IocConfiguration;
import phature.amaranth.simple.framework.ioc.factory.DefaultObjectFactory;
import phature.amaranth.simple.framework.ioc.factory.ObjectFactory;

/**
 * 依赖注入变量类
 *
 * @author phature@qq.com
 * @date 2020-12-24
 * @date 2020-12-24
 */
public class IocVariate {
    private static ObjectFactory objectFactory = new DefaultObjectFactory();
    private static IocConfiguration iocConfiguration;

    /**
     * 获取对象工厂
     *
     * @return 对象工厂
     */
    public static ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    /**
     * 设置对象工厂
     *
     * @param objectFactory 对象工厂
     */
    public static void setObjectFactory(ObjectFactory objectFactory) {
        IocVariate.objectFactory = objectFactory;
    }

    /**
     * 获取依赖注入配置
     *
     * @return 依赖注入配置
     */
    public static IocConfiguration getIocConfiguration() {
        return iocConfiguration;
    }

    /**
     * 设置依赖注入配置
     *
     * @param iocConfiguration 依赖注入配置
     */
    public static void setIocConfiguration(IocConfiguration iocConfiguration) {
        IocVariate.iocConfiguration = iocConfiguration;
    }
}
