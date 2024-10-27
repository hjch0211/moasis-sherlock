package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
