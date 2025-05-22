package com.kolyma.adventure.controller;

import com.kolyma.adventure.dto.EndingDTO;
import com.kolyma.adventure.mapper.EndingMapper;
import com.kolyma.adventure.service.EndingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endings")
public class EndingController {

    private final EndingService endingService;

    public EndingController(EndingService endingService) {
        this.endingService = endingService;
    }

    @GetMapping("/scenario/{scenarioId}")
    public ResponseEntity<List<EndingDTO>> getEndingsByScenario(@PathVariable Long scenarioId) {
        var dtos = endingService.getByScenarioId(scenarioId).stream()
                .map(EndingMapper::toDTO)
                .toList();
        if (dtos.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dtos);
    }
}