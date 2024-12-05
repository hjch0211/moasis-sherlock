package com.moasis_sherlock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameSetting extends TimeStampEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private GameUser gameUser;

    @OneToOne
    private Card criminal;

    @OneToOne
    private Deck userDeck;

    @OneToOne
    private Deck npc1Deck;

    @OneToOne
    private Deck npc2Deck;

    @OneToOne
    private Deck npc3Deck;

    private Boolean isVictory;
}
