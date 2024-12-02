package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String>, HasAnyRow {
}
