package com.example.demo.repository;

import com.example.demo.model.Epigraphs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EpigraphsRepository extends JpaRepository<Epigraphs, Long> {
    //List<Epigraphs> findAll();
}
