package com.xschen.mylearn.singleton.singletonsafe;

import java.io.*;

/**
 * @author xschen
 * todo: 修复序列化破坏单例
 * Java序列化机制的要点：
 * 1、需要序列化的类必须实现java.io.Serializable接口，否则会抛出NotSerializableException异常
 *
 * 2、若没有显示地声明一个serialVersionUID变量，Java序列化机制会根据编译时的class自动生成一个serialVersionUID作为序列化版本比较（验证一致性），
 * 如果检测到反序列化后的类的serialVersionUID和对象二进制流的serialVersionUID不同，则会抛出异常
 *
 * 3、Java的序列化会将一个类包含的引用中所有的成员变量保存下来（深度复制），所以里面的引用类型必须也要实现java.io.Serializable接口
 *
 * 4、当某个字段被声明为transient后，默认序列化机制就会忽略该字段，反序列化后自动获得0或者null值
 *
 * 5、静态成员不参与序列化
 *
 * 6、每个类可以实现readObject、writeObject方法实现自己的序列化策略，
 *    即使是transient修饰的成员变量也可以手动调用ObjectOutputStream的writeInt等方法将这个成员变量序列化。
 *
 * 7、任何一个readObject方法，不管是显式的还是默认的，它都会返回一个新建的实例，这个新建的实例不同于该类初始化时创建的实例
 *
 * 8、每个类可以实现private Object readResolve()方法，在调用readObject方法之后，
 *    如果存在readResolve方法则自动调用该方法，readResolve将对readObject的结果进行处理，而最终readResolve的处理结果将作为readObject的结果返回。
 *    readResolve的目的是保护性恢复对象，其最重要的应用就是保护性恢复单例、枚举类型的对象
 *
 * 9、Serializable接口是一个标记接口，可自动实现序列化，而Externalizable继承自Serializable，它强制必须手动实现序列化和反序列化算法，相对来说更加高效
 */


public class FixSingletonHungrySerializable implements Serializable {
    private static final FixSingletonHungrySerializable instance = new FixSingletonHungrySerializable();

    private FixSingletonHungrySerializable() {
    }

    public static FixSingletonHungrySerializable getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FixSingletonHungrySerializable instance = FixSingletonHungrySerializable.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("single_file_fix"));
        oos.writeObject(instance);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single_file_fix"));
        FixSingletonHungrySerializable newInstance = (FixSingletonHungrySerializable) ois.readObject();

        System.out.println(instance);
        System.out.println(newInstance);
        System.out.println(instance == newInstance);

        oos.close();
        ois.close();
    }
}
