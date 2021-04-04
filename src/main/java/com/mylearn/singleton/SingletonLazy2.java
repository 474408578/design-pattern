package com.mylearn.singleton;

/**
 * @author xschen
 * 懒汉式变种1: 使用Synchronized解决线程安全的问题。
 *
 *  优点：解决了线程不安全的问题
 *  缺点：synchronized对整个getInstance()方法都做了同步，每次只有一个线程能够进入该方法，
 *  并发性能极差
 */

// 线程安全
public class SingletonLazy2 {
    private static SingletonLazy2 instance;

    private SingletonLazy2() {}

    public static synchronized SingletonLazy2 getInstance() {
        if (instance == null) {
            instance = new SingletonLazy2();
        }
        return instance;
    }
}
