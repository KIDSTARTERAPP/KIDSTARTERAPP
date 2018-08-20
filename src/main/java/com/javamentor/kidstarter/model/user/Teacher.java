package com.javamentor.kidstarter.model.user;

import com.javamentor.kidstarter.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode()
@Entity
@Table(name = "teachers")
@NoArgsConstructor
public class Teacher  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "specialization", foreignKey = @ForeignKey(name = "teacher_job_fk"))
    private Set<Job> specialization;
}
