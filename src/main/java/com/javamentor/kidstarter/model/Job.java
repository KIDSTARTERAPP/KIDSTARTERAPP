package com.javamentor.kidstarter.model;

import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.model.user.Mentor;
import com.javamentor.kidstarter.model.user.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public Job(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
