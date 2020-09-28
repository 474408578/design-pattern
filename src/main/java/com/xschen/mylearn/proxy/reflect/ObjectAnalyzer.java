package com.xschen.mylearn.proxy.reflect;

import com.xschen.mylearn.proxy.reflect.entity.Employee;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @author xschen
 * todo: 查看对象数据域实际内容程序
 */


public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();
    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        else if (visited.contains(obj)) {// 如果该对象已经处理过，则不再处理
            return "...";
        }

        visited.add(obj);
        Class c = obj.getClass();
        if (c == String.class) { // 如果是String类型则直接转为String
            return (String) obj;
        }
        if (c.isArray()) { // 如果是数组
            String r = c.getComponentType() + "[]{\n"; // 数组的元素的类型
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",\n";
                }
                r += "\t";
                Object val = Array.get(obj, i);
                if (c.getComponentType().isPrimitive()) { // Class为8种基本类型的时候为true, 直接输出
                    r += val;
                } else {
                    r += toString(val); // 不是8种基本类型，说明是类，递归调用toString
                }
            }
            return r + "\n}";
        }

        // 既不是String，也不是数组时，输出该对象的类型和属性值
        String r = c.getName();
        do {
            r += "[";
            Field[] fields = c.getDeclaredFields(); // 获取该类自己定义的所有域，包括私有的，不包括父类的
            AccessibleObject.setAccessible(fields, true); // 访问私有的属性，需要打开这个设置，否则会报非法访问异常
            for (Field field : fields) {
                if (!Modifier.isStatic(field.getModifiers())) {// 通过 Modifier 可获取该域的修饰符，这里判断是否为 static
                    if (!r.endsWith("[")) {
                        r += ",";
                    }
                    r += field.getName() + " = ";
                    try {
                        Class type = field.getType();
                        Object val = field.get(obj);
                        if (type.isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            c = c.getSuperclass();
        } while (c != null);
        return r;
    }

    public static void main(String[] args) {
        int size = 4;
        ArrayList<Integer> squares = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            squares.add(i * i);
        }
        ObjectAnalyzer objectAnalyzer = new ObjectAnalyzer(); // 创建一个上面定义的分析类ObjectAnalyzer的对象
        System.out.println(objectAnalyzer.toString(squares)); // 分析ArrayList<Integer>对象的实际值

        Employee employee = new Employee("小明", "18", "爱好写代码", 1, "Java攻城狮", 100); // 分析自定义类Employee的对象的实际值
        System.out.println(objectAnalyzer.toString(employee));
    }
}
