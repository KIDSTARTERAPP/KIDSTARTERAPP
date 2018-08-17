package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "sponsor")
public class Sponsor extends User {

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "account", foreignKey = @ForeignKey(name = "sponsor_account_fk"))
    private Account account;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "jury", foreignKey = @ForeignKey(name = "sponsor_jury_fk"))
    private Set<Jury> jury;
}
