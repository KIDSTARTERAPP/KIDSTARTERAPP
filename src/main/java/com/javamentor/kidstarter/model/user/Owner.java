package com.javamentor.kidstarter.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "owners")
public class Owner  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "organization_fk")
    private Organization organization;


    @OneToOne
    @JoinColumn(name ="user_fk")
    private User user;
}