package com.moasis_sherlock.controller;

import com.moasis_sherlock.dto.GameUserDTO;
import com.moasis_sherlock.response.CommonResponse;
import com.moasis_sherlock.service.GameUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "users")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class GameUserController {
    private final GameUserService gameUserService;

    @Operation(summary = "회원가입")
    @PostMapping("/sign-up")
    ResponseEntity<CommonResponse<GameUserDTO.SignUpResponse>> signUp(
            @RequestBody GameUserDTO.SignUpRequest dto
    ) {
        GameUserDTO.SignUpResponse res = gameUserService.signUp(dto);
        return CommonResponse.success(res);
    }

    @Operation(summary = "로그인")
    @PostMapping("/sign-in")
    ResponseEntity<CommonResponse<GameUserDTO.SignInResponse>> signIn(
            @RequestBody GameUserDTO.SignInRequest dto
    ) {
        GameUserDTO.SignInResponse res = gameUserService.signIn(dto);
        return CommonResponse.success(res);
    }
}
