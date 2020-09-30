package com.xschen.mylearn.singleton.singletonsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xschen
 * todo: 反射攻击
 * 在单例模式中，构造器都是私有的，而反射可以通过构造器对象调用 setAccessible(true) 来获得权限，
 * 这样就可以创建多个对象，来破坏单例模式了
 *
 */


public class HungrySingletonReflect {
    private static final HungrySingletonReflect INSTANCE = new HungrySingletonReflect();
    private HungrySingletonReflect() {}

    public static HungrySingletonReflect getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        HungrySingletonReflect instance = HungrySingletonReflect.getInstance();
        Constructor<HungrySingletonReflect> constructor = HungrySingletonReflect.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingletonReflect newInstance = constructor.newInstance();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        /**
         * 输出结果
         * com.xschen.mylearn.singleton.singletonsafe.HungrySingletonReflect@5cad8086
         * com.xschen.mylearn.singleton.singletonsafe.HungrySingletonReflect@6e0be858
         * false
         */
    }
}
