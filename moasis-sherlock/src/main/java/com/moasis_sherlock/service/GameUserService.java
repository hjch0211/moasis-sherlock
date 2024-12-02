package com.moasis_sherlock.service;

import com.moasis_sherlock.dto.GameUserDTO;
import com.moasis_sherlock.entity.GameUser;
import com.moasis_sherlock.exception.CommonException;
import com.moasis_sherlock.repository.GameUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameUserService {
    private final GameUserRepository gameUserRepository;

    @Transactional
    public GameUserDTO.SignUpResponse signUp(GameUserDTO.SignUpRequest dto) {
        if (gameUserRepository.existsById(dto.getId()))
            throw CommonException.ID_DUPLICATED.toException();

        // [Todo] password 단방향 암호화 진행하기
        GameUser gameUser = GameUser.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .build();

        gameUserRepository.save(gameUser);

        return GameUserDTO.SignUpResponse.builder()
                .id(gameUser.getId())
                .build();
    }
}
