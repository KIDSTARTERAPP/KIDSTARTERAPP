package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "teacher")
public class Teacher extends User {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialization", foreignKey = @ForeignKey(name = "teacher_job_fk"))
    private Set<Job> specialization;
}
