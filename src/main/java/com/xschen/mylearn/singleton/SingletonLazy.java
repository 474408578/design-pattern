package com.xschen.mylearn.singleton;

/**
 * @author xschen
 *
 * 懒汉式：
 *  优点：懒加载，启动速度快，如果从始至终都没有使用过这个实例，则不会初始化改实例，可以节约资源
 *  缺点：多线程环境下线程不安全。if(instance == null)存在竞态条件，可能会由多个线程同时进入if语句，导致产生多个实例。
 *
 */

// 线程不安全
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }

        return instance;
    }

}
