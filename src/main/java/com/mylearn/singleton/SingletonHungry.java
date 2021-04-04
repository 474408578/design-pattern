package com.mylearn.singleton;

/**
 * @author xschen
 *
 * todo: 饿汉式单例写法
 *
 * 单例模式三个要点：
 *      1、构造方法私有化
 *      2、实例化的变量引用私有化
 *      3、获取实例的方法公有
 *
 * 饿汉式单例：
 *  优点：简单，使用时没有延迟；在类装载时就完成实例化，天生的线程安全
 *  缺点：没有懒加载，启动较慢；如果从始至终都没使用过这个实例，则会造成内存的浪费。
 */

// 线程安全
public class SingletonHungry {
    private final static SingletonHungry INSTANCE = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance(){
        return INSTANCE;
    }
}
