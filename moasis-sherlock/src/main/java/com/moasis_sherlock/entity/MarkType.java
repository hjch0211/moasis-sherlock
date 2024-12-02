package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MarkType {
    @Id()
    private String name;

    public static MarkType create(String name) {
        return new MarkType(name);
    }
}
