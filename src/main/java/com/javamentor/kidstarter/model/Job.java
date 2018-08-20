package com.javamentor.kidstarter.model;

import com.javamentor.kidstarter.model.user.User;
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
    private Long id;

    @Column (name = "name")
    private String name;

    @ManyToMany
    @JoinColumn (name = "tags", foreignKey = @ForeignKey(name = "job_tag_fk"))
    private Set<Tag> tag;

    @Column (name = "description")
    private String description;


    @ManyToMany
    @JoinColumn (name = "willer", foreignKey = @ForeignKey(name = "job_kid_fk"))
    private Set<User> willer;


	public Job(String name, String description ,Set<Tag> tag, Set<User> willer) {
		this.name = name;
		this.tag = tag;
		this.description = description;
		this.willer = willer;
	}
}
