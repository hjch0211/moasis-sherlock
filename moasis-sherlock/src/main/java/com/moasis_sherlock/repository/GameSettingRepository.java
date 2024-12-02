package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.GameSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSettingRepository extends JpaRepository<GameSetting, String> {
}
