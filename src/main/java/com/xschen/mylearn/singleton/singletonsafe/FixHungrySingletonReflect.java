package com.xschen.mylearn.singleton.singletonsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xschen
 * 单例模式反射攻击解决方案
 *
 * 注：懒汉式的单例模式是无法避免反射攻击的：
 *      因为饿汉的初始化是在类加载的时候，反射一定是在饿汉初始化之后才能使用；
 *      而懒汉是在第一次调用getInstance()方法的时候才初始化，我们无法控制反射和懒汉初始化的先后顺序，
 *      如果反射在前，不管反射创建了多少对象，instance都将一直为null，直到调用getInstance。
 */


public class FixHungrySingletonReflect {
    private static final FixHungrySingletonReflect INSTANCE = new FixHungrySingletonReflect();

    private FixHungrySingletonReflect() {
        if (INSTANCE != null) {
            throw new RuntimeException("单例模式禁止反射调用");
        }
    }

    public static FixHungrySingletonReflect getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        FixHungrySingletonReflect instance = FixHungrySingletonReflect.getInstance();
        Constructor<FixHungrySingletonReflect> constructor = FixHungrySingletonReflect.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        FixHungrySingletonReflect newInstance = constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
    }
}