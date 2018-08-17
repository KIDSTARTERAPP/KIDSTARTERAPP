package com.javamentor.kidstarter.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
<<<<<<< HEAD
=======
@EqualsAndHashCode (callSuper = true)
>>>>>>> f70a8a692c680364c74ff9da39f0baca3625cfc8
@Entity
@Table (name = "administrator")
public class Administrator extends User {
}
