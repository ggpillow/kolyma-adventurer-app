package com.kolyma.adventure.service;

import com.kolyma.adventure.model.Ending;
import com.kolyma.adventure.repository.EndingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndingService {

    private final EndingRepository endingRepository;

    public EndingService(EndingRepository endingRepository) {
        this.endingRepository = endingRepository;
    }

    public List<Ending> getByScenarioId(Long scenarioId) {
        return endingRepository.findByScenario_Id(scenarioId);
    }
}