package com.example.demo.controller;

import com.example.demo.model.Scheme;
import com.example.demo.repository.SchemeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    private final SchemeRepository schemeRepository;

    public SchemeController(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    @GetMapping("/{idScenario}")
    public Scheme getSchemeByScenario(@PathVariable Long idScenario) {
        return schemeRepository.findByIdScenarios(idScenario);
    }
}
