package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jury")
public class Jury {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "account", foreignKey = @ForeignKey(name = "jury_account_fk"))
    private Account account;

    @Column (name = "shortname")
    private String shortName;

    @Column (name = "fullname")
    private String fullName;

    @Column (name = "email")
    private String email;

    @Column (name = "ogrn")
    private Integer ogrn;

    @Column (name = "inn")
    private Integer inn;

    @Column (name = "okpo")
    private Integer okpo;

    @Column (name = "okvad")
    private String okvad;

    @Column (name = "bik")
    private Integer bik;
}
