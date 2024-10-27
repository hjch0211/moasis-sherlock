package com.moasis_sherlock.dto;

import lombok.Builder;
import lombok.Getter;

public class GameDTO {

    @Getter
    public static class ReadRequest {
        String userId;
    }

    @Builder
    public static class ReadyResponse {
        String playId;
    }

    public static class StartResponse {

    }
}
