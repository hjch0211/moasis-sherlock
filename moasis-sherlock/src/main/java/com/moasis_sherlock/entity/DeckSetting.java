package com.moasis_sherlock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeckSetting {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private GameUser customer;

    @Column(name = "customer_id")
    private String userId;

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
