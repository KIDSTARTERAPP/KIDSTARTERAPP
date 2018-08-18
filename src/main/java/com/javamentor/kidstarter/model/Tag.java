package com.javamentor.kidstarter.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "job", foreignKey = @ForeignKey(name = "tag_job_fk"))
    private List<Job> job;

    public Tag(String name, List<Job> job) {
        this.name = name;
        this.job = job;
    }
}
