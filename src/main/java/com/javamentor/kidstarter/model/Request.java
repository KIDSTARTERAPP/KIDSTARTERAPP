package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

/**
 * Sponsor request model.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "header")
    private String header;

    @Column (name = "description")
    private String description;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "kid", foreignKey = @ForeignKey(name = "request_kid_fk"))
    private Set<Kid> kid;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "job", foreignKey = @ForeignKey(name = "request_job_fk"))
    private Job job;

    @Column (name = "price")
    private Long price;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "sponsor", foreignKey = @ForeignKey(name = "request_sponsor_fk"))
    private Set<Sponsor> sponsor;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor", foreignKey = @ForeignKey(name = "request_mentor_fk"))
    private Mentor mentor;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "creator", foreignKey = @ForeignKey(name = "request_creator_fk"))
    private Owner creator;

    @Enumerated (EnumType.STRING)
    private RequestStatus status;

    public enum RequestStatus {
        NEW,
        MODIFIED,
        FUNDING,
        PAID,
        IN_PROGRESS,
        COMPLETED,
        CANCELED,
        REFUNDING
    }
}
