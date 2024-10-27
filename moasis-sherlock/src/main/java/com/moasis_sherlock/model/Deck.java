package com.moasis_sherlock.model;

import com.moasis_sherlock.MarkType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Deck {
    private static final List<Person> persons = new ArrayList<>();

    static {
        addPerson("세바스찬 모런", MarkType.SKULL, MarkType.FIST);
        addPerson("아이린 애들러", MarkType.FIST, MarkType.NECKLACE, MarkType.LIGHT_BULB);
        addPerson("레스트 레이드 경감", MarkType.BADGE, MarkType.EYE, MarkType.BOOK);
        addPerson("그렉슨 경감", MarkType.BADGE, MarkType.FIST, MarkType.BOOK);
        addPerson("베인즈 경감", MarkType.BADGE, MarkType.LIGHT_BULB);
        addPerson("브래드 스트리트 경감", MarkType.BADGE, MarkType.FIST);
        addPerson("홉킨즌 경감", MarkType.BADGE, MarkType.CIGARETTE, MarkType.EYE);
        addPerson("셜록 홈즈", MarkType.CIGARETTE, MarkType.LIGHT_BULB, MarkType.FIST);
        addPerson("존 왓슨", MarkType.CIGARETTE, MarkType.EYE, MarkType.FIST);
        addPerson("마이크로프트 홈즈", MarkType.CIGARETTE, MarkType.EYE, MarkType.LIGHT_BULB);
        addPerson("허드슨 부인", MarkType.CIGARETTE, MarkType.NECKLACE);
        addPerson("메리 모스턴", MarkType.NECKLACE, MarkType.BOOK);
        addPerson("제임스 모리어티", MarkType.SKULL, MarkType.LIGHT_BULB);
    }

    private static void addPerson(String name, MarkType... marks) {
        persons.add(Person.create(name, marks));
    }

    private static List<Person> shuffleAndCopy() {
        List<Person> copy = new ArrayList<>(persons);
        Collections.shuffle(copy);
        return copy;
    }

    @AllArgsConstructor
    public static class Setting {
        private Person criminal;
        private Person[] user;
        private Person[] ncp1;
        private Person[] ncp2;
        private Person[] ncp3;

        public static Setting create() {
            List<Person> copy = shuffleAndCopy();
            Person criminal = copy.remove(0);
            Person[] user = copy.subList(0, 3).toArray(new Person[0]);
            Person[] ncp1 = copy.subList(3, 6).toArray(new Person[0]);
            Person[] ncp2 = copy.subList(6, 9).toArray(new Person[0]);
            Person[] ncp3 = copy.subList(9, 12).toArray(new Person[0]);
            return new Setting(criminal, user, ncp1, ncp2, ncp3);
        }
    }
}
