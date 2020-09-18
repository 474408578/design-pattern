package com.xschen.reflect.proxy.staticproxy;

import com.xschen.reflect.proxy.Order;

/**
 * @Author xschen
 * @Date 2020/7/7 14:45
 */
public class Tests {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
