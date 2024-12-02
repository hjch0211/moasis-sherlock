package com.moasis_sherlock.repository;

import org.springframework.data.jpa.repository.Query;

public interface HasAnyRow {
    // [Error] 현재 이 트랜잭션에 여러 쿼리가 실행되고 있음. -> join까지 다 하고 있음
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT * FROM mark_type) THEN true ELSE false END", nativeQuery = true)
    boolean hasAnyRow();
}
