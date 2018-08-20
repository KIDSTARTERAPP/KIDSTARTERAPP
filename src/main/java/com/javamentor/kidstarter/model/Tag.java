package com.javamentor.kidstarter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;
import javax.persistence.*;


import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
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

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "job_to_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private Set<Job> jobs;

	public Tag(String name, Set<Job> jobs) {
		this.name = name;
		this.jobs = jobs;
	}

    public Tag(String name) {
        this.name = name;
        this.jobs = new HashSet<>();
    }
}
