package phature.amaranth.simple.framework.controller.annotation;

import java.lang.annotation.*;

/**
 * 名称注解
 *
 * @author phature@qq.com
 * @date 2020-12-15
 * @date 2020-12-16
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    /**
     * 值
     *
     * @return 值
     */
    String value() default "";
}
