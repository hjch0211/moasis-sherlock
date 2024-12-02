package com.moasis_sherlock.service;

import com.moasis_sherlock.entity.Card;
import com.moasis_sherlock.entity.Deck;
import com.moasis_sherlock.entity.GameSetting;
import com.moasis_sherlock.entity.GameUser;
import com.moasis_sherlock.exception.CommonException;
import com.moasis_sherlock.repository.CardRepository;
import com.moasis_sherlock.repository.DeckRepository;
import com.moasis_sherlock.repository.GameSettingRepository;
import com.moasis_sherlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameSettingService {
    private final GameSettingRepository deckSettingRepository;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    public int create(String userId) {
        GameUser user = userRepository.findById(userId)
                .orElseThrow(CommonException.ID_NOT_FOUND::toException);

        List<Card> cards = cardRepository.findAll();
        // [Todo] RuntimeException 대신 할 것 찾기
        if (cards.size() < 13) throw new RuntimeException("cards size is less than 13");

        Collections.shuffle(cards);

        Deck userDeck = Deck.builder()
                .cards(Set.of(cards.subList(1, 4).toArray(Card[]::new)))
                .build();
        Deck npc1Deck = Deck.builder()
                .cards(Set.of(cards.subList(4, 7).toArray(Card[]::new)))
                .build();
        Deck npc2Deck = Deck.builder()
                .cards(Set.of(cards.subList(7, 10).toArray(Card[]::new)))
                .build();
        Deck npc3Deck = Deck.builder()
                .cards(Set.of(cards.subList(10, 13).toArray(Card[]::new)))
                .build();

        deckRepository.saveAll(List.of(userDeck, npc1Deck, npc2Deck, npc3Deck));

        GameSetting gameSetting = GameSetting.builder()
                .gameUser(user)
                .criminal(cards.get(0))
                .userDeck(userDeck)
                .npc1Deck(npc1Deck)
                .npc2Deck(npc2Deck)
                .npc3Deck(npc3Deck)
                .build();

        deckSettingRepository.save(gameSetting);

        return gameSetting.getId();
    }
}
