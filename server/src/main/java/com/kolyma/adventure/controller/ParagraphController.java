package com.kolyma.adventure.controller;

import com.kolyma.adventure.dto.ParagraphDTO;
import com.kolyma.adventure.mapper.ParagraphMapper;
import com.kolyma.adventure.service.ParagraphService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paragraphs")
public class ParagraphController {

    private final ParagraphService paragraphService;

    public ParagraphController(ParagraphService paragraphService) {
        this.paragraphService = paragraphService;
    }

    @GetMapping
    public ResponseEntity<List<ParagraphDTO>> getAllParagraphs() {
        var dtos = paragraphService.getAll().stream()
                .map(ParagraphMapper::toDTO)
                .toList();
        if (dtos.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ParagraphDTO>> getById(@PathVariable Long id) {
        var list = paragraphService.getById(id).stream()
                .map(ParagraphMapper::toDTO)
                .toList();
        if (list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/number/{number}")
    public ResponseEntity<List<ParagraphDTO>> getByParagraphNumber(@PathVariable int number) {
        var list = paragraphService.getByParagraphNumber(number).stream()
                .map(ParagraphMapper::toDTO)
                .toList();
        if (list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(list);
    }
}