package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckRepository extends JpaRepository<Deck, Integer> {
}
