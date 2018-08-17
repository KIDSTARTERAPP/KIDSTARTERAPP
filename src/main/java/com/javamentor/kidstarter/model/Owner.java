package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "owner")
public class Owner extends User {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization", foreignKey = @ForeignKey(name = "owner_organization_fk"))
    private Set<Organization> organization;

    public Owner(String firstName, String lastname, String initial, String login, String password, @NotNull List<Role> roles, LocalDateTime createDate, Integer age, String sex, Integer phone, String email, String country, String address) {
        super(firstName, lastname, initial, login, password, roles, createDate, age, sex, phone, email, country, address);
    }
}
