package com.johnny.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 查询的注解
 */
@Retention(RetentionPolicy.RUNTIME) //改变生命周期
@Target(ElementType.METHOD)//改变出现的位置
public @interface Select {
    String value();//配置sql语句的属性
}
