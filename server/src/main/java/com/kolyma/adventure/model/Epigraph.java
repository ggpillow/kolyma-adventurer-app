package com.kolyma.adventure.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "epigraphs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Epigraph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Цитата обязательна")
    private String quote;
}