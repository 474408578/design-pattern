package com.xschen.mylearn.singleton;

/**
 * @author xschen
 * 静态内部类
 * 优点： 避免了线程不安全, 延迟加载，效率高
 *      静态内部类的方式利用了类加载机制来保证线程安全，只有在第一次调用getInstance方法时，
 *      才会装载内部类SingletonInstance内部类，完成SingletonLazy4的实例化，也有懒加载的效果。
 *
 * -----------------------------------------------------------------------------------
 * 加入参数-verbose:class可以查看类加载顺序
 * javac SingletonLazy4.java
 * java -verbose:class SingletonLazy4
 */

// 线程安全
public class SingletonLazy4 {
    private SingletonLazy4() {}

    private static class SingletonInstance {
        private static final SingletonLazy4 INSTANCE = new SingletonLazy4();
    }

    public static SingletonLazy4 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
