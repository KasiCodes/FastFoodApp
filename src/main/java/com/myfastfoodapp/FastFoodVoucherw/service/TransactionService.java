package com.myfastfoodapp.FastFoodVoucherw.service;

import java.util.List;

import com.myfastfoodapp.FastFoodVoucherw.dto.TransactionDTO;

public interface TransactionService {

    List<TransactionDTO> getAllTransactions();

    TransactionDTO getTransactionById(Long id);

    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO);

    void deleteTransaction(Long id);
    
    
}
