package com.javamentor.kidstarter.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.Request;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kids")
public class Kid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kid_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name="organization_id")
    private Organization organization;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "job_to_kid",
            joinColumns = @JoinColumn(name = "kid_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id") )
    private Set<Job> jobInterest;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "request_to_kid",
            joinColumns = @JoinColumn(name = "kid_id"),
            inverseJoinColumns = @JoinColumn(name = "request_id"))
    private Set<Request> requests;

    public Kid(User user, Organization org, Set<Job> jobInterest) {
        this.user = user;
        this.jobInterest = jobInterest;
        this.organization = org;
    }
}
