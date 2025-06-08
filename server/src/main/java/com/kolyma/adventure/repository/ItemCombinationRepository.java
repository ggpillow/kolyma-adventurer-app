package com.kolyma.adventure.repository;

import com.kolyma.adventure.model.ItemCombination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemCombinationRepository extends JpaRepository<ItemCombination, Long> {
    Optional<ItemCombination> findByResource1_IdAndResource2_Id(Long resource1Id, Long resource2Id);
}