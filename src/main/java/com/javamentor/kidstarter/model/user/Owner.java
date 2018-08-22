package com.javamentor.kidstarter.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Owner(Organization organization, User user) {
        this.organization = organization;
        this.user = user;
    }
}