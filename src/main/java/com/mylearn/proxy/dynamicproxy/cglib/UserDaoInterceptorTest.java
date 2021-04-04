package com.mylearn.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author xschen
 */


public class UserDaoInterceptorTest {
    public static void main(String[] args) {
        UserDaoInterceptor userDaoInterceptor = new UserDaoInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(userDaoInterceptor);

        UserDao userDaoProxy = (UserDao) enhancer.create();
        userDaoProxy.select();
        userDaoProxy.update();
    }
}
