package com.javamentor.kidstarter.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode (callSuper = true)
@Entity
@Table (name = "administrator")
public class Administrator extends User {
}
