package com.xschen.mylearn.singleton;

/**
 * @author xschen
 * 枚举类实现单例模式
 *
 * 优点：通过JDK1.5中添加的枚举来实现单例模式，写法简单，且不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 */

// 枚举类型是线程安全的，并且只会被装载一次
public class   SingletonLazy5 {
    private SingletonLazy5() {}

    private enum Singleton {
        INSTANCE;

        private final SingletonLazy5 instance;
        Singleton() {
            instance = new SingletonLazy5();
        }

        private SingletonLazy5 getInstance() {
            return instance;
        }
    }

    public static SingletonLazy5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

}
