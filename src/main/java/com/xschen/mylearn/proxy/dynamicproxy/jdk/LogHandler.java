package com.xschen.mylearn.proxy.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

/**
 * @author xschen
 * 为了让生成的代理类与目标对象（真实主题角色）保持一致性，从现在开始将介绍以下两种最常见的方式：
 * 1、通过实现接口的方式 --> JDK动态代理
 * 2、通过继承类的方式 --> CGLIB动态代理
 *
 * JDK动态代理主要涉及两个类：java.lang.reflect.Proxy和java.lang.reflect.InvocationHandler
 * InvocationHandler的主要方法介绍如下：
 *   Object invoke(Object proxy, Method method, Object[] args) 定义了代理对象调用方法时希望执行的动作，用于集中处理在动态代理类对象上的方法调用。
 *
 * Proxy的主要方法介绍如下：
 *   static InvocationHandler getInvocationHandler(Object proxy) 用于获取指定代理对象所关联的调用处理器
 *
 *   static Class<?> getProxyClass(ClassLoader loader, Class<?>... interfaces) 返回指定接口的代理类
 *
 *   static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 *   构造实现指定接口的代理类的一个新实例，所有方法会调用给定处理器对象的 invoke 方法
 *
 *   static boolean isProxyClass(Class<?> cl) 返回 cl 是否为一个代理类
 *
 * todo: 编写一个调用逻辑处理器 LogHandler 类，提供日志增强功能，并实现 InvocationHandler 接口;
 * 在 LogHandler 中维护一个目标对象，这个对象是被代理的对象（真实主题角色）；
 * 在 invoke 方法中编写方法调用的逻辑处理.
 */


public class LogHandler implements InvocationHandler {
    Object target; // 被代理的对象，实际方法的执行者

    public LogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args); // 调用target的method方法
        after();
        return result; // 返回方法的执行结果
    }


    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }

    public static void main(String[] args) {
        // 1、创建被代理的对象，UserService接口的实现类
        UserService userService = new UserServiceImpl();

        // 2、获取对应的ClassLoader
        ClassLoader classLoader = userService.getClass().getClassLoader();

        // 3、获取所有接口的Class，这里的UserServiceImpl只实现了一个接口UserService
        Class[] interfaces = userService.getClass().getInterfaces();

        // 4、创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        // 这里创建的是一个自定义的日志处理器，需传入实际的实行对象UserServiceImpl
        InvocationHandler logHandler = new LogHandler(userService);

        // 5、根据上面的提供的信息，创建代理对象，在这个过程中：
        //  a、JDK会根据传入的参数信息在内存中创建和.class文件等同的字节码
        //  b、然后根据相应的字节码转换成对应的class
        //  c、然后调用newInstance()创建代理实例
        UserService proxy = (UserService) Proxy.newProxyInstance(classLoader, interfaces, logHandler);
        proxy.select();
        proxy.update();

        // 获取指定代理对象所关联的调用处理器
        System.out.println(Proxy.getInvocationHandler(proxy));

        // 返回指定接口的代理类
        System.out.println(Proxy.getProxyClass(userService.getClass().getClassLoader()));

        // 返回class是否为一个代理类
        System.out.println(Proxy.isProxyClass(proxy.getClass()));

        // 保存JDK动态代理生成的代理类，类名为UserServiceProxy
        ProxyUtils.generateClassFile(userService.getClass(), "UserServiceProxy");
    }
}
