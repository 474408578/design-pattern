package com.xschen.reflect.proxy.staticproxy;

import com.xschen.reflect.proxy.IOrderService;
import com.xschen.reflect.proxy.Order;
import com.xschen.reflect.proxy.OrderServiceImpl;
import com.xschen.reflect.proxy.db.DataSourceContextHolder;

/**
 * @Author xschen
 * @Date 2020/7/7 13:09
 */
public class OrderServiceStaticProxy {
    private IOrderService orderService;

    public int saveOrder(Order order) {
        beforeMethod(order);

        orderService = new OrderServiceImpl();
        int result = orderService.saveOrder(order);

        AfterMethod();

        return result;
    }

    private void beforeMethod(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");

        // todo 设置DataSource
        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
        System.out.println("静态代理 before code");
    }

    private void AfterMethod() {
        System.out.println("静态代理 after code");
    }
}
