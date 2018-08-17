package com.javamentor.kidstarter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;

    @Column (name = "content")
    private String content;

    @Column (name = "createdate")
    private LocalDateTime createDate;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "author", foreignKey = @ForeignKey(name = "author_user_fk"))
    private User author;

    @Column (name = "header")
    private String header;

    @Column (name = "rate")
    private Integer rate;
}
