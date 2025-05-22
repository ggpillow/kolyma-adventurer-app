package com.kolyma.adventure.repository;

import com.kolyma.adventure.model.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {

    // Найти все абзацы с определённым номером
    List<Paragraph> findByParagraphNumber(int paragraphNumber);
}