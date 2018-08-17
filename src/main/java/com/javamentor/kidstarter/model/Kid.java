package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode (callSuper = true)
@Entity
@Table(name = "kid")
public class Kid extends User {


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "jobinterest", foreignKey = @ForeignKey(name = "kid_job_fk"))
    private Set<Job> jobInterest;
}
