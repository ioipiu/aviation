package cn.kgc.aviation.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标志性注解
 */
@Target(ElementType.METHOD)  // 方法和方法参数
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface Logger {
    /**
     * 如果注解只有一个属性，那么肯定是赋值给该属性。
     * 如果注解有多个属性，而且前提是这多个属性都有默认值，那么你不写注解名赋值，会赋值给名字为“value”这属性。
     * 如果注解有多个属性，其中有没有设置默认值的属性，那么当你不写属性名进行赋值的时候，是会报错的。
     */
    String value() default "";
}
