package com.javamentor.kidstarter.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamentor.kidstarter.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "teachers")
@NoArgsConstructor
public class Teacher  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany
    @JoinTable(name = "teacher_to_jobs",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> specialization;
}
