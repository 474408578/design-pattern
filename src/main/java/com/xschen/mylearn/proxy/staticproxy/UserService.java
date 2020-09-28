package com.xschen.mylearn.proxy.staticproxy;

/**
 * @author xschen
 *
 * 代理模式按照职责（使用场景）来分类，至少可以分为以下几类：1、远程代理。
 * 2、虚拟代理。
 * 3、Copy-on-Write 代理。
 * 4、保护（Protect or Access）代理。
 * 5、Cache代理。
 * 6、防火墙（Firewall）代理。
 * 、同步化（Synchronization）代理。
 * 8、智能引用（Smart Reference）代理等等。
 *
 * 如果根据字节码的创建时机来分类，可以分为静态代理和动态代理：
 *
 * 所谓静态也就是在程序运行前就已经存在代理类的字节码文件，代理类和真实主题角色的关系在运行前就确定了。
 *
 * 而动态代理的源码是在程序运行期间由JVM根据反射等机制动态的生成，所以在运行前并不存在代理类的字节码文件
 */


public interface UserService {
    void select();
    void update();
}
