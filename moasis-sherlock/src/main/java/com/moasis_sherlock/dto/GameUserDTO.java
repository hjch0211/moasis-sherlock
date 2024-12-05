package com.moasis_sherlock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class GameUserDTO {
    @Getter
    public static class SignUpRequest {
        private String id;
        private String password;
    }

    @Builder
    @Getter // ResponseEntity에서 사용되므로 필요
    public static class SignUpResponse {
        private String id;
    }

    @Getter
    public static class SignInRequest {
        private String id;
        private String password;
    }

    @Builder
    @Getter
    public static class SignInResponse {
        private String id;
    }
}
