package com.example.usersdemo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// INHERITANCE: kel entity bte3mol "extends BaseEntity" btewras id w createdAt
// abstract = ma fik ta3mol "new BaseEntity()", huwe bas la yetwaras
@MappedSuperclass
public abstract class BaseEntity {

    // ENCAPSULATION: private, ma had byegh'ayyer el id men barra
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    // Btenfaz automatic abel ma yetsajjal el record bel database
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    // Ma fi setId() w la setCreatedAt(): hayde encapsulation,
    // el database w Spring homme bi7addedouhon, mesh enta.
}
