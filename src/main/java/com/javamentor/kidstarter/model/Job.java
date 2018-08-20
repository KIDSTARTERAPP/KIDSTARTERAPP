package com.javamentor.kidstarter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.javamentor.kidstarter.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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

    @EqualsAndHashCode.Exclude
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "job_to_tag",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

    @Column (name = "description")
    private String description;


    @ManyToMany
    @JoinColumn (name = "willer", foreignKey = @ForeignKey(name = "job_kid_fk"))
    private Set<User> willer;


	public Job(String name, String description ,Set<Tag> tags, Set<User> willer) {
		this.name = name;
		this.tags = tags;
		this.description = description;
		this.willer = willer;
	}
}
