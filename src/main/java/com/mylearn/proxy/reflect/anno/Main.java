package com.mylearn.proxy.reflect.anno;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        person.age = 22;
        test(person);
    }

    public static void test(Object object) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> c = object.getClass();

        Field ageField = c.getDeclaredField("age");
        System.out.println(ageField.getInt(object));

        Method method = c.getDeclaredMethod("sayHello");
        // 暴力反射
        method.setAccessible(true);
        method.invoke(object);


        // System.out.println(c.isAnnotationPresent(MyAnno.class));
        System.out.println(ageField.getDeclaredAnnotation(MyAnno.class).name());

    }
}


@MyAnno
class Person {
    // 赋值
    @MyAnno(name = "bb")
    int age;

    // private
    @MyAnno
    private void sayHello() {
        System.out.println("hello");
    }
}
