package com.kolyma.adventure.service;

import com.kolyma.adventure.model.Paragraph;
import com.kolyma.adventure.repository.ParagraphRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParagraphService {

    private final ParagraphRepository paragraphRepository;

    public ParagraphService(ParagraphRepository paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    public List<Paragraph> getAll() {
        return paragraphRepository.findAll();
    }

    public List<Paragraph> getById(Long id) {
        return paragraphRepository.findAllById(List.of(id)); // Вернёт список даже по одному ID
    }

    public List<Paragraph> getByParagraphNumber(int number) {
        return paragraphRepository.findByParagraphNumber(number);
    }
}
