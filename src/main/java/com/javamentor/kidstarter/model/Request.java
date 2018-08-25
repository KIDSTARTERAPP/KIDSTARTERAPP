package com.javamentor.kidstarter.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javamentor.kidstarter.model.user.*;
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
@Table(name = "request")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column (name = "description", nullable = false)
	private String description;

	@OneToOne
	@JoinColumn(name ="job_fk")
	private Job job;

	@EqualsAndHashCode.Exclude
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "request_to_kid",
			joinColumns = @JoinColumn(name = "request_id"),
			inverseJoinColumns = @JoinColumn(name = "kid_id"))
	private Set<Kid> kids;

	@EqualsAndHashCode.Exclude
    @JsonIgnore
	@ManyToMany
	@JoinTable(name = "request_to_teacher",
			joinColumns = @JoinColumn(name = "request_id"),
			inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Teacher> teachers;

	@Column (name = "price", nullable = false)
	private Long price;

	@OneToMany
	@JoinTable(name = "sponsors",
			joinColumns = @JoinColumn(name = "sponsor_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id") )
	private Set<User> sponsors;

	@OneToOne
	@JoinColumn(name ="mentor_fk")
	private Mentor mentor;

	@OneToOne
	@JoinColumn(name ="account_fk")
	private Account account;

	@OneToOne
	@JoinColumn(name ="creator_fk")
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

	public Request(String description, Job job, Set<Kid> kids, Set<Teacher> teachers, Long price, Set<User> sponsors, Mentor mentor, Account account, Owner creator) {
		this.description = description;
		this.job = job;
		this.kids = kids;
		this.teachers = teachers;
		this.price = price;
		this.sponsors = sponsors;
		this.mentor = mentor;
		this.account = account;
		this.creator = creator;
	}
}
