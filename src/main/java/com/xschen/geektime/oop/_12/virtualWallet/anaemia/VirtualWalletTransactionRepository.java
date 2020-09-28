package com.xschen.geektime.oop._12.virtualWallet.anaemia;

/**
 * @author xschen
 */


public class VirtualWalletTransactionRepository {
    public Long saveTransaction(VirtualWalletTransactionEntity transactionEntity) {
        VirtualWalletTransactionEntity walletTransactionEntity = new VirtualWalletTransactionEntity();
        walletTransactionEntity.setCreateTime(transactionEntity.getCreateTime());
        walletTransactionEntity.setFromWalletId(transactionEntity.getFromWalletId());
        walletTransactionEntity.setToWalletId(transactionEntity.getToWalletId());
        walletTransactionEntity.setAmount(transactionEntity.getAmount());
        walletTransactionEntity.setStatus(transactionEntity.getStatus());

        // 保存的逻辑

        Long result = new Long(1);
        return result;
    }

    public void updateStatus(Long transactionId, Status executed) {
        // 通过transactionId查出transactionEntity
        VirtualWalletTransactionEntity walletTransactionEntity = new VirtualWalletTransactionEntity();
        walletTransactionEntity.setStatus(executed);
        // 更新的逻辑
    }
}
