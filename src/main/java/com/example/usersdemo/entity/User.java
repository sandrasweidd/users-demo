package com.example.usersdemo.entity;

import jakarta.persistence.*;

// CLASS: hayda el "qaleb" taba3 el user. Kel row bel table = object.
// INHERITANCE: extends BaseEntity => 3ando id w createdAt bala ma nektobon
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    // ENCAPSULATION: kel el fields private
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    // JPA bte7taj constructor fadi
    protected User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Ma fi getPassword() public 3an 2asd: ma bedna had yesta3mela bel API.

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El esm ma lazem ykoun fadi");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
