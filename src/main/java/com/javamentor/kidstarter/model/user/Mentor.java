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
@Table(name = "mentors")
public class Mentor  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_fk")
    private User user;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch =  FetchType.EAGER)
    @JoinTable(name = "mentor_to_jobs",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> job;

    @Column(name = "description", nullable = false)
    private String description;

    @Column (name = "experience")
    private Integer experience;

//    @OneToMany (cascade = CascadeType.ALL)
//    @JoinColumn (name = "comment", foreignKey = @ForeignKey(name = "mentor_comment_fk"))
//    private Set<Comment> comment;


    public Mentor(User user, Set<Job> job, Integer experience, String description) {
        this.user = user;
        this.job = job;
        this.experience = experience;
        this.description = description;
    }
}