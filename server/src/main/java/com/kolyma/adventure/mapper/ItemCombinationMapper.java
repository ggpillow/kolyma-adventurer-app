package com.kolyma.adventure.mapper;

import com.kolyma.adventure.dto.ItemCombinationDTO;
import com.kolyma.adventure.model.ItemCombination;
import com.kolyma.adventure.model.Resource;

public class ItemCombinationMapper {

    public static ItemCombinationDTO toDTO(ItemCombination entity) {

        return new ItemCombinationDTO(
                entity.getId(),
                entity.getResource1().getId(),
                entity.getResource2().getId(),
                entity.getResultItem(),
                entity.getImageItems()
        );
    }

    public static ItemCombination toEntity(ItemCombinationDTO dto, Resource res1, Resource res2) {
        System.out.println("Запрошены ресурсы: " + res1 + " и " + res2);
        ItemCombination entity = new ItemCombination();
        entity.setId(dto.getId());
        entity.setResource1(res1);
        entity.setResource2(res2);
        entity.setResultItem(dto.getResultItem());
        entity.setImageItems(dto.getImageItems());
        return entity;
    }
}