package com.javamentor.kidstarter.model.user;

import com.javamentor.kidstarter.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode ()
@Entity
@Table(name = "kids")
@NoArgsConstructor
public class Kid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kid_id")
    private Long id;



    @ManyToMany
    @JoinColumn (name = "jobinterest", foreignKey = @ForeignKey(name = "kid_job_fk"))
    private Set<Job> jobInterest;
}
