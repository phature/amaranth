package phature.amaranth.simple.framework.ioc.factory;

/**
 * 对象工厂接口
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-24
 */
public interface ObjectFactory {
    /**
     * 实例化
     *
     * @param interfaceClass 接口类
     * @param instanceClass  实例类
     * @param <Interface>    接口
     * @return 实例
     */
    <Interface> Interface instance(Class<Interface> interfaceClass, Class<?> instanceClass);
}
