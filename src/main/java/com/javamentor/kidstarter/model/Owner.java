package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "owner")
public class Owner extends User {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization", foreignKey = @ForeignKey(name = "owner_organization_fk"))
    private Set<Organization> organization;
}
