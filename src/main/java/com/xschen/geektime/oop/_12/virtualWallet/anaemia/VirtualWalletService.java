package com.xschen.geektime.oop._12.virtualWallet.anaemia;

import java.math.BigDecimal;

/**
 * @author xschen
 */


public class VirtualWalletService {
    private VirtualWalletRepository walletRepository;
    private VirtualWalletTransactionRepository transactionRepository;

    public VirtualWalletBo getVirtualWallet(Long walletId) {
        VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
        VirtualWalletBo walletBo = convert(walletEntity);
        return walletBo;
    }

    private VirtualWalletBo convert(VirtualWalletEntity walletEntity) {
        // 做转换后，返回一个BO
        return null;
    }


    public BigDecimal getBalance(Long walletId) {
        return walletRepository.getBalance(walletId);
    }

    public void debit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        if (balance.compareTo(amount) < 0) {
            throw new RuntimeException("余额不足！");
        }
        walletRepository.updateBalance(walletId, balance.subtract(amount));
    }

    public void credit(Long walletId, BigDecimal amount) {
        VirtualWalletEntity walletEntity = walletRepository.getWalletEntity(walletId);
        BigDecimal balance = walletEntity.getBalance();
        walletRepository.updateBalance(walletId, balance.add(amount));
    }


    // 需要保证原子性
    public void transfer(Long fromWalletId, Long toWalletId, BigDecimal amount) {
        VirtualWalletTransactionEntity transactionEntity = new VirtualWalletTransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setFromWalletId(fromWalletId);
        transactionEntity.setToWalletId(toWalletId);
        transactionEntity.setCreateTime(System.currentTimeMillis());
        transactionEntity.setStatus(Status.TO_BE_EXECUTED);
        Long transactionId = transactionRepository.saveTransaction(transactionEntity);
        try {
            debit(fromWalletId, amount);
            credit(toWalletId, amount);
        } catch (RuntimeException e ) {
            transactionRepository.updateStatus(transactionId, Status.CLOSED);
        } catch (Exception e) {
            transactionRepository.updateStatus(transactionId, Status.FAILED);
        }
        transactionRepository.updateStatus(transactionId, Status.EXECUTED);

    }
}
