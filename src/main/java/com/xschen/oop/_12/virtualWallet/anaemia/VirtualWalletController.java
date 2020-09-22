package com.xschen.oop._12.virtualWallet.anaemia;

import java.math.BigDecimal;

/**
 * @author xschen
 */


public class VirtualWalletController {

    private VirtualWalletService walletService; // 通过构造函数或者IOC框架注入

    /**
     * 查询余额
     * @param walletId
     * @return
     */
    public BigDecimal getBalance(Long walletId) {
        return walletService.getBalance(walletId);
    }

    /**
     * 出账
     * @param walletId
     * @param amount
     */
    public void debit(Long walletId, BigDecimal amount) {
        walletService.debit(walletId, amount);
    }

    /**
     * 入账
     * @param walletId
     * @param amount
     */
    public void credit(Long walletId, BigDecimal amount) {
        walletService.credit(walletId, amount);
    }

    /**
     * 转账
     * @param fromWalletId
     * @param toWalletId
     * @param amount
     */
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        walletService.transfer(fromWalletId, toWalletId, amount);

    }
}
