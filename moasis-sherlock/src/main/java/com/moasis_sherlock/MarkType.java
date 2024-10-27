package com.moasis_sherlock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MarkType {
    CIGARETTE("cigarette"),
    LIGHT_BULB("light bulb"),
    FIST("fist"),
    BADGE("badge"),
    BOOK("book"),
    NECKLACE("necklace"),
    EYE("eye"),
    SKULL("skull");

    private final String name;
}
