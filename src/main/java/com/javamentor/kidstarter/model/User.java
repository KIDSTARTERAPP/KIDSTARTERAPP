package com.javamentor.kidstarter.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public  class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter
    private Long id;

    @Column(name ="firstName", nullable = false)
    @Getter
    @Setter
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @Getter
    @Setter
    private String lastname;

    @Column(name = "login", nullable = false)
    @Getter
    @Setter
    private String login;

    @Column(name = "password", nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(name = "initial", nullable = false)
    @Getter
    @Setter
    private String initial;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "permissions",
            joinColumns = {@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_ROLE"))})
    @Getter
    @Setter
    private List<Role> roles;

    @Column(name = "createDate", nullable = false)
    @Getter
    @Setter
    private LocalDateTime createDate;

    @Column(name = "age", nullable = false)
    @Getter
    @Setter
    private Integer age;

    @Column(name = "sex", nullable = false)
    @Getter
    @Setter
    private String sex;

    @Column(name ="phone", nullable = false)
    @Getter
    @Setter
    private Integer phone;

    @Column(name = "email", nullable = false)
    @Getter
    @Setter
    private String email;

    @Column(name = "country", nullable = false)
    @Getter
    @Setter
    private String country;

    @Column(name = "address", nullable = false)
    @Getter
    @Setter
    private String address;

    @Override
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
