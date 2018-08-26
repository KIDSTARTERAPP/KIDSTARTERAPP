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

    @Column (name = "need_amount")
    private Long needAmount;

    @Column (name = "currenr_amount")
    private Long currentAmount;

    public Account(Long needAmount, Long currentAmount) {
        this.needAmount = needAmount;
        this.currentAmount = currentAmount;
    }
}
