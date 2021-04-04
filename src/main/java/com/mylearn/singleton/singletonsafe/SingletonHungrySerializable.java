package com.mylearn.singleton.singletonsafe;

import java.io.*;

/**
 * @author xschen
 * todo: 通过java序列化机制来攻击单例
 * ---------------------------------------------------------
*/


public class SingletonHungrySerializable implements Serializable{
    private static final SingletonHungrySerializable instance = new SingletonHungrySerializable();
    private SingletonHungrySerializable() {}

    public static SingletonHungrySerializable getInstance() {
        return instance;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingletonHungrySerializable instance = SingletonHungrySerializable.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_file"));
        oos.writeObject(instance);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single_file"));
        SingletonHungrySerializable newInstance = (SingletonHungrySerializable) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);
        /**
         * 输出结果
         * com.xschen.mylearn.singleton.singletonsafe.SingletonHungry@511d50c0
         * com.xschen.mylearn.singleton.singletonsafe.SingletonHungry@6f496d9f
         * false
         */

        oos.close();
        ois.close();
    }
}
