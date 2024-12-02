package com.moasis_sherlock.repository;

import com.moasis_sherlock.entity.DeckSetting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckSettingRepository extends JpaRepository<DeckSetting, String> {
}
