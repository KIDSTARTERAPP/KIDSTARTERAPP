package com.javamentor.kidstarter.model;

import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private Account fromAccount;
    private Account toAccount;
    private Long amount;
    private LocalDateTime transactionDate;
    private Enum transactionType;
    private Enum transactionStatus;
}
