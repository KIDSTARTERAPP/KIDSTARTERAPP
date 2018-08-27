package com.javamentor.kidstarter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table (name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "account_id")
    private Long id;

    @Column (name = "current_amount")
    private Long currentAmount;

    public Account(Long currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Account() {
        this.currentAmount = 0L;
    }
}
