package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "tag", foreignKey = @ForeignKey(name = "job_tag_fk"))
    private Set<Tag> tag;

    @Column (name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "willer", foreignKey = @ForeignKey(name = "job_kid_fk"))
    private Set<User> willer;
}
