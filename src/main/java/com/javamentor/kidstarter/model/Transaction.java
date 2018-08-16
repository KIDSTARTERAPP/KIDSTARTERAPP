package com.javamentor.kidstarter.model;

import java.time.LocalDateTime;

/**
 * Account transaction entry model.
 */
public class Transaction {

    private Long id;
    private Account fromAccount;
    private Account toAccount;
    private Long amount;
    private LocalDateTime transactionDate;
    private TransactionTypes transactionType;
    private TransactionStatus transactionStatus;
}
