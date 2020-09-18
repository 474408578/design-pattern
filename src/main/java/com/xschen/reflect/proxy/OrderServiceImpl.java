package com.xschen.reflect.proxy;

/**
 * @Author xschen
 * @Date 2020/7/7 12:52
 */
public class OrderServiceImpl implements IOrderService {

    private IOrderDao orderDao;


    @Override
    public int saveOrder(Order order) {
        // Spring会自己注入，此处直接使用new
        IOrderDao orderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");

        return orderDao.insert(order);
    }
}
