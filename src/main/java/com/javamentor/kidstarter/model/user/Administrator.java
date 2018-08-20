package com.javamentor.kidstarter.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode ()
@Entity
@NoArgsConstructor
@Table (name = "administrators")
public class Administrator   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @OneToOne
    @JoinColumn(name =  "user_fk")
    private User user;

}
