package com.javamentor.kidstarter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    @Column (name = "need_amount")
    private Long needAmount;

    public Account(Long needAmount, Long currentAmount) {
        this.currentAmount = currentAmount;
        this.needAmount = needAmount;
    }
}
