package com.xschen.mylearn.proxy.reflect;

import com.xschen.mylearn.proxy.reflect.entity.Employee;

/**
 * @author xschen
 *
 * http://laijianfeng.org/2018/12/Java%E5%8F%8D%E5%B0%84%E6%9C%BA%E5%88%B6%E8%AF%A6%E8%A7%A3/
 *
 * 反射(Reflection) 是 Java 在运行时（Run time）可以访问、检测和修改它本身状态或行为的一种能力，
 * 它允许运行中的 Java 程序获取自身的信息，并且可以操作类或对象的内部属性。
 *
 * Class 类介绍：Java虚拟机为每个类型管理一个Class对象，包含了与类有关的信息，
 * 当通过 javac 编译Java类文件时，生成的同名 .class 文件保存着该类的 Class 对象，JVM 加载一个类即是加载该 .class 文件。
 *
 * Class 和 java.lang.reflect 一起对反射提供了支持，java.lang.reflect 包中最主要的三个类 ：
 * Field、Method 和 Constructor 分别用于描述类的域、方法和构造器，
 * 它们有一个共同的父类 AccessibleObject，它提供了访问控制检查的功能。
 *
 * todo：获取Class对象的三种方式:
 * 1、使用Class类的forName静态方法
 * 2、直接获取某一个对象的class
 * 3、调用某个对象的getClass()方法
 */


public class ClassTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.xschen.mylearn.proxy.reflect.entity.Employee");

        Class c2 = Employee.class;

        Employee employee = new Employee("小明", "18", "coding", 1, "Java程序员", 10000);
        Class c3 = employee.getClass();
        if (c1 == c2 && c2 == c3) {
            System.out.println("c1、c2、c3 为同一个对象");
            System.out.println(c1);     // class reflect.Employee
        }
    }

}
