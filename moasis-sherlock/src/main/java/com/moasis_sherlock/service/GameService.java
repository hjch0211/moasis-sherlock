package com.moasis_sherlock.service;

import com.moasis_sherlock.dto.GameDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameSettingService gameSettingService;

    @Transactional
    public GameDTO.ReadyResponse ready(String userId) {
        int gameId = gameSettingService.create(userId);

        return GameDTO.ReadyResponse.builder()
                .gameId(gameId)
                .build();
    }
}
