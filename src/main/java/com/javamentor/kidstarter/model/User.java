package com.javamentor.kidstarter.model;

import java.time.LocalDateTime;

public abstract class User {

    private Long id;
    private String firstName;
    private String lastname;
    private String initials;
    private Role role;
    private LocalDateTime createDate;
    private Integer age;
    private String sex;
    private Integer phone;
    private String email;
    private String country;
    private String address;
}
