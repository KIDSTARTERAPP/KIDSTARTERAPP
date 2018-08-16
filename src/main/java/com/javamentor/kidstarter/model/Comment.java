package com.javamentor.kidstarter.model;

import java.time.LocalDateTime;

public class Comment {

    private Long id;
    private String content;
    private LocalDateTime createDate;
    private User author;
    private String header;
    private Integer rate;
}
