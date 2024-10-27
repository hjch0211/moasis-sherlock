package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Person {
    @Id
    private String name;

    @ManyToMany
    private Set<MarkType> marks;
}
