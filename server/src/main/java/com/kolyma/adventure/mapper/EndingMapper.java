package com.kolyma.adventure.mapper;

import com.kolyma.adventure.dto.EndingDTO;
import com.kolyma.adventure.model.Ending;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndingMapper {

    public static EndingDTO toDTO(Ending ending) {
        if (ending == null) return null;
        return new EndingDTO(
                ending.getId(),
                ending.getTitleEnding(),
                ending.getEndDescr(),
                ending.getScenario() != null ? ending.getScenario().getId() : null
        );
    }

    public static Ending toEntity(EndingDTO dto) {
        if (dto == null) return null;
        Ending ending = new Ending();
        ending.setId(dto.getId());
        ending.setTitleEnding(dto.getTitleEnding());
        ending.setEndDescr(dto.getEndDescr());
        // Связь со сценарием устанавливается отдельно
        return ending;
    }
}