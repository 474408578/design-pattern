package com.geektime.oop._07;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 *
 * 不要滥用getter、setter方法：除非真的需要，否则尽量不要给属性定义setter方法，
 * 尽管getter方法相对setter方法要安全一些，但是如果返回的是集合容器，也要防范集合内存数据被修改的危险
 */


public class ShoppingCart {
    private int itemsCount;
    private BigDecimal totalPrice;
    private List<ShoppingCartItem> items = new ArrayList<>();

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    // 如果返回的是集合容器，也要防范集合内存数据被修改的危险
    /*
    public List<ShoppingCartItem> getItems() {
        return items;
    }*/


    public void addItem(ShoppingCartItem item) {
        items.add(item);
        itemsCount++;
        totalPrice = totalPrice.add(item.getPrice());
    }

    /**
     * 清空购物车（正确的逻辑）
     */
    public void clear() {
        items.clear();
        itemsCount = 0;
        totalPrice = BigDecimal.ZERO;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
//        cart.getItems().clear();// 也会清空购物车


    }
}

class ShoppingCartItem {
    private String name;
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
