package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.GameSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameSettingRepository extends JpaRepository<GameSetting, String> {
    List<GameSetting> findByGameUserId(String userId);
}
