package com.moasis_sherlock.service;

import com.moasis_sherlock.entity.DeckSetting;
import com.moasis_sherlock.entity.Person;
import com.moasis_sherlock.exception.CommonException;
import com.moasis_sherlock.repository.DeckSettingRepository;
import com.moasis_sherlock.repository.PersonRepository;
import com.moasis_sherlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GameSettingService {
    private final DeckSettingRepository deckSettingRepository;
    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public void create(String userId) {
        if (!userRepository.existsById(userId)) throw CommonException.ID_NOT_FOUND.toException();

        List<Person> persons = personRepository.findAll();
        // [Todo] RuntimeException 대신 할 것 찾기
        if (persons.size() < 13) throw new RuntimeException("persons size is less than 13");

        Collections.shuffle(persons);

        DeckSetting deckSetting = DeckSetting.builder()
                .userId(userId)
                .criminal(persons.get(0))
                .userDeck(Set.of(persons.subList(1, 4).toArray(Person[]::new)))
                .ncp1Deck(Set.of(persons.subList(4, 7).toArray(Person[]::new)))
                .ncp2Deck(Set.of(persons.subList(7, 10).toArray(Person[]::new)))
                .ncp3Deck(Set.of(persons.subList(10, 13).toArray(Person[]::new)))
                .build();

        deckSettingRepository.save(deckSetting);
    }
}
