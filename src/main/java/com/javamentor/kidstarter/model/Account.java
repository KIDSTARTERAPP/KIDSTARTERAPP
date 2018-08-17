package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "amount")
    private Long amount;
}
