package com.moasis_sherlock.controller;

import com.moasis_sherlock.dto.GameDTO;
import com.moasis_sherlock.response.CommonResponse;
import com.moasis_sherlock.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// [Todo] 인텔리제이를 껏다 안켜도 build.gradle 내용이 반영되게 하기.
@Tag(name = "games")
@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    // 인가 처리 필요
    @Operation(summary = "게임 준비", description = "카드 분배와 범인이 정해집니다.")
    @PostMapping("/ready")
    ResponseEntity<CommonResponse<GameDTO.ReadyResponse>> ready(
            @RequestBody GameDTO.ReadRequest dto
    ) {
        GameDTO.ReadyResponse res = gameService.ready(dto.getUserId());
        return CommonResponse.success(res);
    }

//    @PostMapping("/start/:id")
//    ResponseEntity<CommonResponse<GameDTO.StartResponse>> start() {
//        GameDTO.StartResponse res = gameService.start();
//        return CommonResponse.success(res);
//    }
}
