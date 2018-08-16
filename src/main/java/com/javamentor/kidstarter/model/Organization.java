package com.javamentor.kidstarter.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Organization {

    private Long id;
    private String name;
    private Set<Owner> owner;
    private String address;
    private String country;
    private String email;
    private Integer phone;
    private LocalDateTime createDate;
    private Account account;
    private Set<Request> requestSer;
}
