package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
