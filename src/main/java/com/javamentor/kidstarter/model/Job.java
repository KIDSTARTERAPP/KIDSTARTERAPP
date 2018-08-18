package com.javamentor.kidstarter.model;

import com.javamentor.kidstarter.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinColumn (name = "tag", foreignKey = @ForeignKey(name = "job_tag_fk"))
    private List<Tag> tag;

    @Column (name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "willer", foreignKey = @ForeignKey(name = "job_kid_fk"))
    private List<User> willer;

    public Job(String name, String description, List<User> willer) {
        this.name = name;
        this.description = description;
        this.willer = willer;
    }
}
