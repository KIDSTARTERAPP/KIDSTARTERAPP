package com.javamentor.kidstarter.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamentor.kidstarter.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode()
@Entity
@Table(name = "kids")
@NoArgsConstructor
public class Kid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kid_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "kids_to_jobs",
            joinColumns = @JoinColumn(name = "kid_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> jobInterest;

}
