package com.xschen.reflect.proxy;

/**
 * @Author xschen
 * @Date 2020/7/7 12:52
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
