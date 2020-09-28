package com.xschen.geektime.oop._12.virtualWallet.anaemia;

import java.math.BigDecimal;

/**
 * @author xschen
 */


public class VirtualWalletRepository {
    public VirtualWalletEntity getWalletEntity(Long walletId) {
        // 根据walletId查询数据库后返回
        VirtualWalletEntity walletEntity = new VirtualWalletEntity();
        return walletEntity;
    }

    public BigDecimal getBalance(Long walletId) {
        // 根据walletId查询数据库后返回
        BigDecimal balance = new BigDecimal(0);
        return balance;
    }

    public void updateBalance(Long walletId, BigDecimal subtract) {
        // 根据walletId查询数据库后返回
        VirtualWalletEntity walletEntity = new VirtualWalletEntity();
        walletEntity.setBalance(subtract);
    }
}
