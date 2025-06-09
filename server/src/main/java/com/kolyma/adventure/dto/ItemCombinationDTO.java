package com.kolyma.adventure.dto;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCombinationDTO {
    private Long id;

    @NotNull
    private Long resource1Id;

    @NotNull
    private Long resource2Id;

    @NotNull
    private String resultItem;

    @NotNull
    private String imageItems;
}