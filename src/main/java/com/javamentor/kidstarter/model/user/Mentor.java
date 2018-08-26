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
    @ManyToMany
    @JoinTable(name = "job_to_mentor",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> job;

    @Column(name = "description", nullable = false)
    private String description;

    @Column (name = "experience")
    private Integer experience;

    @Column (name = "x")
    private double pointX;

    @Column (name = "y")
    private double pointY;

//    @OneToMany (cascade = CascadeType.ALL)
//    @JoinColumn (name = "comment", foreignKey = @ForeignKey(name = "mentor_comment_fk"))
//    private Set<Comment> comment;


    public Mentor(User user, Set<Job> job, Integer experience, String description, double pointX, double pointY) {
        this.user = user;
        this.job = job;
        this.experience = experience;
        this.description = description;
        this.pointX = pointX;
        this.pointY = pointY;
    }
}