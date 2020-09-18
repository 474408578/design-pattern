package com.xschen.reflect;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Target -> 指定注解作用的地方：类、方法、成员变量
 * Retention -> 需要什么级别保存该注解信息  （Java源文件、class文件、字节码阶段）
 *      RetentionPolicy.SOURCE //只存在于java源文件中，会被编译器丢弃
 *      RetentionPolicy.CLASS//保留到class文件中，但会被jvm丢弃
 *      RetentionPolicy.RUNTIME//一直保留到jvm在运行期间，可以通过反射机制获取注解的信息
 *
 *
 *
 */
//@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    // 给name属性赋值
    String name() default "aa";
}
