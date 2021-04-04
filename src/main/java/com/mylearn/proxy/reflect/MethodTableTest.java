package com.mylearn.proxy.reflect;

import com.mylearn.proxy.reflect.entity.Employee;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xschen
 * todo: 调用任意方法
 */


public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Employee employee = new Employee("小明", "18", "写代码", 1, "Java攻城狮", 100000);
        Method sayHello = employee.getClass().getMethod("sayHello");
        System.out.println(sayHello);
        sayHello.invoke(employee);

        double x = 3.0;
        Method square = MethodTableTest.class.getMethod("square", double.class);
        double y1 = (double) square.invoke(null, x);
        System.out.printf("square    %-10.4f -> %10.4f%n", x, y1);

        Method sqrt = Math.class.getMethod("sqrt", double.class);   // 获取 Math 的 sqrt 方法
        double y2 = (double) sqrt.invoke(null, x);  // 调用类方法 sqrt 求根，方法参数 x
        System.out.printf("sqrt      %-10.4f -> %10.4f%n", x, y2);
    }

    // static静态方法 计算乘方
    public static double square(double x) {
        return x * x;
    }
}
