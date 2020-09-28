package com.xschen.mylearn.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * @author xschen
 */


public class UserDaoFilterTest {
    public static void main(String[] args) {
        UserDaoInterceptor userDaoProxy = new UserDaoInterceptor();
        UserDaoFilter userDaoFilter = new UserDaoFilter();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        // 设置过个拦截器，NoOp.INSTANCE是一个空拦截器，不做任何处理
        enhancer.setCallbacks(new Callback[] {userDaoProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(userDaoFilter);

        UserDao userDao = (UserDao) enhancer.create();
        userDao.select();
        userDao.update();
    }
}
