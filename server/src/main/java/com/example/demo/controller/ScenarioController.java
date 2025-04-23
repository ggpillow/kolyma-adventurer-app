package com.example.demo.controller;

import com.example.demo.dto.ScenarioDTO;
import com.example.demo.model.Scenario;
import com.example.demo.repository.ScenarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
public class ScenarioController {

    private final ScenarioRepository scenarioRepository;

    public ScenarioController(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    @GetMapping
    public List<ScenarioDTO> getAllScenarios() {
        return scenarioRepository.findAll().stream()
                .map(s -> new ScenarioDTO(
                        s.getId(),
                        s.getTitle(),
                        s.getStartDescr(),
                        s.getMiniDescription(),
                        s.getImageURL(),
                        s.getDifficulty()
                ))
                .toList();
    }

    @PostMapping
    public Scenario createScenario(@RequestBody Scenario scenario){
        return scenarioRepository.save(scenario);
    }
}
