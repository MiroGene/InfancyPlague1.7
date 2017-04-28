package com.test.base.annotation;

import com.test.base.aspect.enums.LogLevel;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/4/24.
 */
@Target(ElementType.METHOD)//注解用在方法上，用于描述方法
@Retention(RetentionPolicy.RUNTIME)//注解在运行时保留
@Documented//指定javadoc生成API文档时显示该注解信息
public @interface InvokeLog {
    String value() default "";
    String start() default "---------------开始---------------";
    String end() default "---------------结束---------------";

    LogLevel logLevel() default LogLevel.info;
}
