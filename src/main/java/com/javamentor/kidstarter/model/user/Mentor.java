package com.javamentor.kidstarter.model.user;

import com.javamentor.kidstarter.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "mentors")
public class Mentor  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "jobs", foreignKey = @ForeignKey(name = "mentor_job_fk"))
    private Set<Job> job;

    @Column (name = "experience")
    private Integer experience;

//    @OneToMany (cascade = CascadeType.ALL)
//    @JoinColumn (name = "comment", foreignKey = @ForeignKey(name = "mentor_comment_fk"))
//    private Set<Comment> comment;
}