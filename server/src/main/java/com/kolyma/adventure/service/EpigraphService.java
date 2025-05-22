package com.kolyma.adventure.service;

import com.kolyma.adventure.model.Epigraph;
import com.kolyma.adventure.repository.EpigraphRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}