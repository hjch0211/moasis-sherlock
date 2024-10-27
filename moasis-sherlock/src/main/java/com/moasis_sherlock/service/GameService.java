package com.moasis_sherlock.service;

import com.moasis_sherlock.dto.GameDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameSettingService gameSettingService;

    public GameDTO.ReadyResponse ready(String userId) {
        gameSettingService.create(userId);

        return GameDTO.ReadyResponse.builder()
                .playId(userId)
                .build();
    }
}
