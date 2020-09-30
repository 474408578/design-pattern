package com.xschen.mylearn.singleton;

/**
 * @author xschen
 * 饿汉式变种
 */

// 线程安全
public class SingletonHungry2 {
    private static SingletonHungry2 instance;

    static {
        instance = new SingletonHungry2();
    }

    private SingletonHungry2() {
    }

    public static SingletonHungry2 getInstance() {
        return instance;
    }
}
