package com.mylearn.proxy.staticproxy;

import java.util.Date;

/**
 * @author xschen
 * todo: 通过静态代理对UserServiceImpl进行功能增强，
 * 在调用select和update之前记录一些日志，代理类需要实现UserService
 *
 * http://laijianfeng.org/2018/12/Java-%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E8%AF%A6%E8%A7%A3/
 * --------------------------------------------------------------------
 * 静态代理的缺点
 * 1、 当需要代理多个类的时候，由于代理对象要实现与目标对象一致的接口，有两种方式：
 *      只维护一个代理类，由这个代理类实现多个接口，但是这样就导致代理类过于庞大
 *      新建多个代理类，每个目标对象对应一个代理类，但是这样会产生过多的代理类
 *
 * 2、当接口需要增加、删除、修改方法的时候，目标对象与代理类都要同时修改，不易维护。
 *
 * -----------------------------------------------------------------------
 * 为什么类可以动态的生成？
 * Java虚拟机类加载过程分为：加载、验证、准备、解析、初始化，加载阶段需要完成3件事：
 *  1、通过一个类的全限定名来获取定义此类的二进制字节流
 *  2、这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
 *  3、在内存中生成一个代表这个类的 java.lang.Class 对象，作为方法区这个类的各种数据访问入口
 *
 * 获取类的二进制字节流（class字节码）就有很多途径：
 *
 * 从ZIP包获取，这是JAR、EAR、WAR等格式的基础
 * 从网络中获取，典型的应用是 Applet
 * 运行时计算生成，这种场景使用最多的是动态代理技术，在 java.lang.reflect.Proxy 类中，
 * 就是用了 ProxyGenerator.generateProxyClass 来为特定接口生成形式为 *$Proxy 的代理类的二进制字节流
 * 由其它文件生成，典型应用是JSP，即由JSP文件生成对应的Class类
 * 从数据库中获取等等
 *
 * 所以，动态代理就是想办法，根据接口或目标对象，计算出代理类的字节码，然后再加载到JVM中使用。
 * 但是如何计算？如何生成？情况也许比想象的复杂得多，我们需要借助现有的方案。
 *
 * ----------------------------------------------------------------------------
 * 常见的字节码操作类库
 * Apache BCEL (Byte Code Engineering Library)：是Java classworking广泛使用的一种框架，它可以深入到JVM汇编语言进行类操作的细节。
 *
 * ObjectWeb ASM：是一个Java字节码操作框架。它可以用于直接以二进制形式动态生成stub根类或其他代理类，或者在加载时动态修改类。
 *
 * CGLIB(Code Generation Library)：是一个功能强大，高性能和高质量的代码生成库，用于扩展JAVA类并在运行时实现接口。
 *
 * Javassist：是Java的加载时反射系统，它是一个用于在Java中编辑字节码的类库; 它使Java程序能够在运行时定义新类，并在JVM加载之前修改类文件。
 */


public class UserServiceProxy implements UserService {
    private UserService userService; // 被代理的对象

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void select() {
        before();
        userService.select();
        after();
    }

    @Override
    public void update() {
        before();
        userService.select();
        after();
    }

    private void before() {
        System.out.println(String.format("log start time [%s] ", new Date()));
    }

    private void after() {
        System.out.println(String.format("log end time [%s] ", new Date()));
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        UserService proxy = new UserServiceProxy(userService);

        proxy.select();
        proxy.update();
    }
}
