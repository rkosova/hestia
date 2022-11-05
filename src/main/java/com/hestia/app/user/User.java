package com.hestia.app.user;

import com.hestia.app.project.Project;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String l_name;
    private String email;
    private String password;


    public User(Long id, String name, String l_name, String email, String password) {
        this.id = id;
        this.name = name;
        this.l_name = l_name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String l_name, String email, String password) {
        this.name = name;
        this.l_name = l_name;
        this.email = email;
        this.password = password;
    }

    public User() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
