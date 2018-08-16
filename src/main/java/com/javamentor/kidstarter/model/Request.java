package com.javamentor.kidstarter.model;

import java.util.Set;

public class Request {

    private Long id;
    private String header;
    private String description;
    private Set<Kid> kid;
    private Job job;
    private Long price;
    private Set<Sponsor> sponsor;
    private Mentor mentor;
    private Owner creator;
    private Enum status;
}
