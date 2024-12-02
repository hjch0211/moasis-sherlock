package com.moasis_sherlock.config;

import com.moasis_sherlock.entity.Card;
import com.moasis_sherlock.entity.MarkType;
import com.moasis_sherlock.repository.CardRepository;
import com.moasis_sherlock.repository.MarkTypeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class RunnerConfig {
    private final CardRepository cardRepository;
    private final MarkTypeRepository markTypeRepository;

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Transactional
    public ApplicationRunner initTable() {
        return args -> {
            if (markTypeRepository.hasAnyRow()) {
                log.info("MarkType 테이블 데이터가 이미 존재합니다.");
                return;
            } else if (cardRepository.hasAnyRow()) {
                log.info("Card 테이블 데이터가 이미 존재합니다.");
                return;
            }

            MarkType[] markTypes = new MarkType[]{
                    MarkType.create("cigarette"),
                    MarkType.create("light bulb"),
                    MarkType.create("fist"),
                    MarkType.create("badge"),
                    MarkType.create("book"),
                    MarkType.create("necklace"),
                    MarkType.create("eye"),
                    MarkType.create("skull")
            };
            markTypeRepository.saveAll(Arrays.asList(markTypes));


            Card[] cards = new Card[]{
                    Card.create("세바스찬 모런", markTypes[7], markTypes[2]),
                    Card.create("아이린 애들러", markTypes[2], markTypes[5], markTypes[1]),
                    Card.create("레스트 레이드 경감", markTypes[3], markTypes[6], markTypes[4]),
                    Card.create("그렉슨 경감", markTypes[3], markTypes[2], markTypes[4]),
                    Card.create("베인즈 경감", markTypes[3], markTypes[1]),
                    Card.create("브래드 스트리트 경감", markTypes[3], markTypes[2]),
                    Card.create("홉킨즌 경감", markTypes[3], markTypes[0], markTypes[6]),
                    Card.create("셜록 홈즈", markTypes[0], markTypes[1], markTypes[2]),
                    Card.create("존 왓슨", markTypes[0], markTypes[6], markTypes[2]),
                    Card.create("마이크로프트 홈즈", markTypes[0], markTypes[6], markTypes[1]),
                    Card.create("허드슨 부인", markTypes[0], markTypes[5]),
                    Card.create("메리 모스턴", markTypes[5], markTypes[4]),
                    Card.create("제임스 모리어티", markTypes[7], markTypes[1])

            };
            cardRepository.saveAll(Arrays.asList(cards));

            log.info("Card 테이블 데이터 생성 완료");
        };
    }

    @Bean
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ApplicationRunner helloServer() {
        return args -> {
            log.info("http://localhost:8080");// [Test] 포트 env로 가져오게 설장하기
        };
    }
}
