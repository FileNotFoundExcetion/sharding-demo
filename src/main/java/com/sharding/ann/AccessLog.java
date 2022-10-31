package com.sharding.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  添加日志
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AccessLog {
    /**
     * 该方法名称，业务名称
     *
     * @return
     */
    String value() default "";

    /**
     * 是否打印请求参数
     *
     * @return
     */
    boolean isPrintReqParams() default true;

    /**
     * 是否打印响应结果
     *
     * @return
     */
    boolean isPrintRes() default false;
}
