package com.kolyma.adventure.mapper;

import com.kolyma.adventure.dto.ParagraphDTO;
import com.kolyma.adventure.model.Paragraph;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ParagraphMapper {

    public static ParagraphDTO toDTO(Paragraph paragraph) {
        if (paragraph == null) return null;
        return new ParagraphDTO(
                paragraph.getId(),
                paragraph.getParagraphNumber(),
                paragraph.getParagraphDescr()
        );
    }

    public static Paragraph toEntity(ParagraphDTO dto) {
        if (dto == null) return null;
        Paragraph paragraph = new Paragraph();
        paragraph.setId(dto.getId());
        paragraph.setParagraphNumber(dto.getParagraphNumber());
        paragraph.setParagraphDescr(dto.getParagraphDescr());
        return paragraph;
    }
}