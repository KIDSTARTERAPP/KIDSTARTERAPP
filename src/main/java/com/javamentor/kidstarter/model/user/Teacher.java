package com.javamentor.kidstarter.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamentor.kidstarter.model.Job;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "teachers")
public class Teacher  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany
    @JoinTable(name = "job_to_teacher",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> specialization;

    public Teacher(User user, Set<Job> specialization) {
        this.user = user;
        this.specialization = specialization;
    }
}
