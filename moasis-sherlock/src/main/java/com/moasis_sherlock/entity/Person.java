package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String name;

    @ManyToMany
    private Set<MarkType> marks;

    public static Person create(String name, MarkType... marks) {
        return new Person(name, Set.of(marks));
    }
}
