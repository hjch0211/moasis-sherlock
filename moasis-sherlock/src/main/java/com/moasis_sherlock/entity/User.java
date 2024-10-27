package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
    @Id
    private String id;

    @NotBlank
    private String password;
}
