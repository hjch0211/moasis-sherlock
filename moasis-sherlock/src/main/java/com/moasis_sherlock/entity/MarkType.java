package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MarkType {
    @Id
    private String name;
}
