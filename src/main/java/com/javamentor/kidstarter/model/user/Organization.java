package com.javamentor.kidstarter.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
    @JoinColumn (name = "account_fk")
    private Account account;

    @OneToMany
    @JoinColumn (name = "kids")
    private Set<Kid> kid;

    @OneToMany
    @JoinColumn (name = "teachers")
    private Set<Teacher> teachers;

    public Organization(String name, String address, String country, String email, Integer phone, LocalDateTime createDate, Account account) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.createDate = createDate;
        this.account = account;
    }

    //    @ManyToMany (cascade = CascadeType.ALL)
//    @JoinColumn (name = "request", foreignKey = @ForeignKey(name = "organization_request_fk"))
//    private Set<Request> request;
}