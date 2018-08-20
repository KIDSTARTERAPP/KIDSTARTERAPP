package com.javamentor.kidstarter.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;

    @Column (name = "name", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn (name = "owners", foreignKey = @ForeignKey(name = "organization_owner_fk"))
    private  Owner owner;

    @Column (name = "address",nullable = false)
    private String address;

    @Column (name = "country", nullable = false)
    private String country;

    @Column (name = "email",nullable = false)
    private String email;

    @Column (name = "phone",nullable = false)
    private Integer phone;

    @Column (name = "createdate", nullable = false)
    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn (name = "account", foreignKey = @ForeignKey(name = "organization_account_fk"))
    private Account account;

//    @ManyToMany (cascade = CascadeType.ALL)
//    @JoinColumn (name = "request", foreignKey = @ForeignKey(name = "organization_request_fk"))
//    private Set<Request> request;
}