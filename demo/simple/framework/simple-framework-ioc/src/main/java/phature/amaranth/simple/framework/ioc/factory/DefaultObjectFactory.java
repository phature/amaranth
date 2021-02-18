package phature.amaranth.simple.framework.ioc.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 默认对象工厂类
 *
 * @author phature@qq.com
 * @date 2020-12-07
 * @date 2020-12-24
 */
public class DefaultObjectFactory implements ObjectFactory {
    private final static Logger logger = LoggerFactory.getLogger(DefaultObjectFactory.class);

    @Override
    public <Interface> Interface instance(Class<Interface> interfaceClass, Class<?> instanceClass) {
        Interface result = null;

        if (null != interfaceClass && null != instanceClass) {
            try {
                Constructor<?> constructor = instanceClass.getDeclaredConstructor();
                result = (Interface) constructor.newInstance();
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException exception) {
                logger.error(exception.getMessage(), exception);
            }
        }

        return result;
    }
}
