package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<GameUser, String> {
}
