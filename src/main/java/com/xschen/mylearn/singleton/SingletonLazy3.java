package com.xschen.mylearn.singleton;

/**
 * @author xschen
 *
 * 双重检查锁
 * 1、为何要double-check ？
 *
 * 2、volatile的作用：
 *  a、保证可见性
 *  b、禁止重排序
 *
 */

// 线程安全
public class SingletonLazy3 {
    private static volatile SingletonLazy3 instance;

    private SingletonLazy3() {}

    public static SingletonLazy3 getInstance() {
        if (instance == null) { // 判断单例是否存在, 如果存在直接返回
            synchronized (SingletonLazy3.class) { // 单例不存在，会进入synchronized保护区域
                if (instance == null) { // 再次判断是否为单例
                    instance = new SingletonLazy3();
                }
            }
        }
        return instance;
    }
}
