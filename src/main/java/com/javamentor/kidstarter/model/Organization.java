package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "owner", foreignKey = @ForeignKey(name = "organization_owner_fk"))
    private Set<Owner> owner;

    @Column (name = "address")
    private String address;

    @Column (name = "country")
    private String country;

    @Column (name = "email")
    private String email;

    @Column (name = "phone")
    private Integer phone;

    @Column (name = "createdate")
    private LocalDateTime createDate;


    @ManyToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "request", foreignKey = @ForeignKey(name = "organization_request_fk"))
    private Set<Request> request;
}
