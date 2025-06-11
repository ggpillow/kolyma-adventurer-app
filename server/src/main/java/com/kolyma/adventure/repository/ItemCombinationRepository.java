package com.kolyma.adventure.repository;

import com.kolyma.adventure.model.ItemCombination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemCombinationRepository extends JpaRepository<ItemCombination, Long> {

    @Query("SELECT ic FROM ItemCombination ic " +
            "WHERE (ic.resource1.id = :res1 AND ic.resource2.id = :res2) " +
            "   OR (ic.resource1.id = :res2 AND ic.resource2.id = :res1)")
    Optional<ItemCombination> findByResourcePair(@Param("res1") Long res1, @Param("res2") Long res2);
}