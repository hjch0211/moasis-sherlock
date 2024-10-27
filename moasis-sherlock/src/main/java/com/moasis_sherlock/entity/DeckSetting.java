package com.moasis_sherlock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

import java.util.Set;

@Entity
public class DeckSetting {
    @Id
    private String id;

    @OneToOne
    private Person criminal;

    @ManyToMany
    private Set<Person> userDeck;

    @ManyToMany
    private Set<Person> ncp1Deck;

    @ManyToMany
    private Set<Person> ncp2Deck;

    @ManyToMany
    private Set<Person> ncp3Deck;
}
