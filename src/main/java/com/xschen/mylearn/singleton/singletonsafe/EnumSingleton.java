package com.xschen.mylearn.singleton.singletonsafe;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xschen
 *
 * http://laijianfeng.org/2019/01/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F-%E5%8D%95%E4%BE%8B%E6%A8%A1%E5%BC%8F%E5%8F%8A%E5%85%B8%E5%9E%8B%E5%BA%94%E7%94%A8/
 *
 * 实现单例模式的唯一推荐方法，是使用枚举类来实现。
 *
 * 为什么推荐使用枚举单例？
 * 1、枚举单例写法简单
 *
 * 2、线程安全&懒加载
 *      代码中 INSTANCE 变量被 public static final 修饰，因为static类型的属性是在类加载之后初始化的，JVM可以保证线程安全；
 *      且Java类是在引用到的时候才进行类加载，所以枚举单例也有懒加载的效果。
 *
 * 3、枚举自己能避免序列化攻击
 *
 * 4、枚举能够避免反射攻击，因为反射不支持创建枚举对象
 *      Constructor类的 newInstance方法中会判断是否为 enum，若是会抛出异常
 */


public enum EnumSingleton implements Serializable {
    INSTANCE;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private EnumSingleton() {}

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;

        singleton1.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取的内容：" + singleton1.getContent());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("EnumSingleton.obj"));
        oos.writeObject(singleton1);
        oos.flush();
        oos.close();

        FileInputStream fis = new FileInputStream("EnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        EnumSingleton singleton2 = (EnumSingleton) ois.readObject();
        ois.close();
        System.out.println(singleton1 + "\n" + singleton2);
        System.out.println("枚举序列化后读取其中的内容：" + singleton2.getContent());
        System.out.println("枚举序列化前后两个是否同一个：" + (singleton1 == singleton2));

        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        EnumSingleton singleton3 = constructor.newInstance();
        System.out.println("反射后读取其中的内容：" + singleton3.getContent());
        System.out.println("反射前后两个是否同一个： " + (singleton1 == singleton3));

        /**
         * 运行结果：
         * 枚举序列化前读取的内容：枚举单例序列化
         * INSTANCE
         * INSTANCE
         * 枚举序列化后读取其中的内容：枚举单例序列化
         * 枚举序列化前后两个是否同一个：true
         * Exception in thread "main" java.lang.NoSuchMethodException: com.xschen.mylearn.singleton.singletonsafe.EnumSingleton.<init>()
         * 	at java.lang.Class.getConstructor0(Class.java:3082)
         * 	at java.lang.Class.getDeclaredConstructor(Class.java:2178)
         * 	at com.xschen.mylearn.singleton.singletonsafe.EnumSingleton.main(EnumSingleton.java:46)
         */
    }
}
