package com.kolyma.adventure.service;

import com.kolyma.adventure.model.Epigraph;
import com.kolyma.adventure.repository.EpigraphRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class EpigraphService {

    private final EpigraphRepository epigraphRepository;

    public EpigraphService(EpigraphRepository epigraphRepository) {
        this.epigraphRepository = epigraphRepository;
    }

    public List<Epigraph> getAll() {
        return epigraphRepository.findAll();
    }

    public Optional<Epigraph> getById(Long id) {
        return epigraphRepository.findById(id);
    }

    public Epigraph getRandom() {
        List<Epigraph> all = epigraphRepository.findAll();
        if (all.isEmpty()) throw new RuntimeException("Нет эпиграфов");
        return all.get(new Random().nextInt(all.size()));
    }
}