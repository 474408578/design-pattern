package com.mylearn.proxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * @author xschen
 * todo: 通过反射来创建实例
 * 1、使用Class对象的newInstance()方法来创建Class对象对应类的实例
 * 2、先通过Class对象获取指定的Constructor对象，再调用Constructor对象的newInstance()方法来创建实例
 */


public class NewInstanceTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c = Date.class;
        Date date1 = (Date) c.newInstance();
        System.out.println(date1);

        long timestamp = date1.getTime();
        Constructor constructor = c.getConstructor(long.class);
        Date date2 = (Date) constructor.newInstance(timestamp);
        System.out.println(date2);

    }

}
