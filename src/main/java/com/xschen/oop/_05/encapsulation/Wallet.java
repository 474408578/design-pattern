package com.xschen.oop._05.encapsulation;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * OOP: 封装特性
 *
 * 小知识：BigDecimal类型的加减乘除运算：
 *      加：add
 *      减：subtract
 *      乘：multiply
 *      除：divide
 *      0: BigDecimal.ZERO
 */

public class Wallet {
    private String id;
    private long createTime;
    private BigDecimal balance;
    private long balanceLastModifiedTime;
    // 省略其他属性...

    public Wallet() {
//        this.id = IdGenerator.getInstance().generate(); // id生成器
        this.id = UUID.randomUUID().toString();
        this.createTime = System.currentTimeMillis();
        this.balance = BigDecimal.ZERO;
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }


    public long getCreateTime() {
        return createTime;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public long getBalanceLastModifiedTime() {
        return balanceLastModifiedTime;
    }

    public void increaseBalance(BigDecimal increasedAmount) {
        if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        this.balance.add(increasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }

    public void decreaseBalance(BigDecimal decreasedAmount) {
        if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("参数不合法");
        }

        if (decreasedAmount.compareTo(this.balance) > 0) {
            throw new IllegalArgumentException("参数过大");
        }

        this.balance.subtract(decreasedAmount);
        this.balanceLastModifiedTime = System.currentTimeMillis();
    }
}
