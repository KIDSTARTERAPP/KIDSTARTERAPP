package com.javamentor.kidstarter.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity                                     // означает что этот класс является представлениемм в базе данных.
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = AUTO)        // указывает что ID автогенерируемый.
	@Column(name = "id")
	private Long id;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "sex")
	private String sex;

	@Column(name = "phoneNumber")
	private int phoneNumber;

	@Column(name = "country")
	private String country;
}





