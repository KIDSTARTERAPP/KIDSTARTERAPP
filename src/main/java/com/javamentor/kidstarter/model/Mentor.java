package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mentor")
public class Mentor extends Sponsor {

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "job", foreignKey = @ForeignKey(name = "mentor_job_fk"))
    private Set<Job> job;

    @Column (name = "experience")
    private Integer experience;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "comment", foreignKey = @ForeignKey(name = "mentor_comment_fk"))
    private Set<Comment> comment;
}
