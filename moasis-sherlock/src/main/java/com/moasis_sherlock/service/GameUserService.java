package com.moasis_sherlock.service;

import com.moasis_sherlock.dto.GameUserDTO;
import com.moasis_sherlock.entity.GameUser;
import com.moasis_sherlock.exception.CommonException;
import com.moasis_sherlock.repository.GameUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameUserService {
    private final GameUserRepository gameUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public GameUserDTO.SignUpResponse signUp(GameUserDTO.SignUpRequest dto) {
        if (gameUserRepository.existsById(dto.getId()))
            throw CommonException.ID_DUPLICATED.toException();

        GameUser gameUser = GameUser.builder()
                .id(dto.getId())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();

        gameUserRepository.save(gameUser);

        return GameUserDTO.SignUpResponse.builder()
                .id(gameUser.getId())
                .build();
    }

    public GameUserDTO.SignInResponse signIn(GameUserDTO.SignInRequest dto) {
        GameUser gameUser = gameUserRepository.findById(dto.getId())
                .orElseThrow(CommonException.USER_NOT_FOUND::toException);

        if (!passwordEncoder.matches(dto.getPassword(), gameUser.getPassword()))
            throw CommonException.PASSWORD_MISMATCH.toException();

        return GameUserDTO.SignInResponse.builder()
                .id(gameUser.getId())
                .build();
    }
}
