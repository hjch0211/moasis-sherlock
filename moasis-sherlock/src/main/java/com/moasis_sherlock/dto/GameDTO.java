package com.moasis_sherlock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class GameDTO {
    @Getter
    public static class ReadyRequest {
        private String userId;
    }

    @Builder
    @Getter
    public static class ReadyResponse {
        private int gameId;
    }

    @Getter
    public static class GamesResponse {
        private int id;
        private String userId;
        private boolean isFinished;
        private LocalDateTime createdAt;
    }
}
