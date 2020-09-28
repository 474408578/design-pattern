package com.xschen.mylearn.proxy.dynamicproxy.jdk;

/**
 * @author xschen
 */


public class UserServiceImpl implements UserService {
    @Override
    public void select() {
        System.out.println("查询selectById");
    }

    @Override
    public void update() {
        System.out.println("更新update");
    }
}
