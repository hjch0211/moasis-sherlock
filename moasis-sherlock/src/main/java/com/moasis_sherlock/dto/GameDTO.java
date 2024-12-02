package com.moasis_sherlock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class GameDTO {
    @Getter
    public static class ReadyRequest {
        String userId;
    }

    @Builder
    @Getter
    public static class ReadyResponse {
        int gameId;
    }
}
