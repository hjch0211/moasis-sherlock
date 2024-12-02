package com.moasis_sherlock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameSetting {
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

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private boolean isVictory;
}
