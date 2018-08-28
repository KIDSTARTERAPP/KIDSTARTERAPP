package com.javamentor.kidstarter.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name ="firstName")
  // @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN)
    private String firstName;

    @Column(name = "lastName")
 //   @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN)
    private String lastName;

    @Column(name = "patronymic")
    //    @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN)
    private String patronymic;

    @Column(name = "login")
    private String login;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "password")
    private String password;

    @EqualsAndHashCode.Exclude
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "permissions",
            joinColumns = {@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_ROLE"))})
    private List<Role> roles = new ArrayList<>();

    @Column(name = "createDate")
    private LocalDateTime createDate;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name ="phone")
    private String phone;

    @Column(name = "email")
  //  @Email(regexp = ValidationPattern.EMAIL_PATTERN)
    private String email;

    @Column(name = "country")
    private String country;

    @Column(name = "address")
    private String address;

    @OneToOne
    @JoinColumn(name = "account_fk")
    private Account account;



    public User(String firstName, String lastName, String patronymic, String login, String password,
                @NotNull List<Role> roles, Integer age, String sex, String  phone,
                String email, String country, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.roles = roles;
        this.createDate = LocalDateTime.now();
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.address = address;
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
