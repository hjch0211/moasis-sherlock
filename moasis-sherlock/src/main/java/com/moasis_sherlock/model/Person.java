package com.moasis_sherlock.model;

import com.moasis_sherlock.MarkType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Person {
    private final String name;
    private final MarkType[] marks;

    public static Person create(String name, MarkType[] marks) {
        return new Person(name, marks);
    }
}