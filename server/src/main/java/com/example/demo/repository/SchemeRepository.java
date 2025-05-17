package com.example.demo.repository;

import com.example.demo.model.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepository  extends JpaRepository<Scheme, Long> {
    Scheme findByIdScenarios(Long idScenarios);
}
