package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Schemes")
public class Scheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_scenarios")
    private Long idScenarios;

    @Column(name = "image_schemes")
    private String imageSchemes;

    public Scheme () {}

    public Scheme(Long idScenarios, String imageSchemes) {
        this.idScenarios = idScenarios;
        this.imageSchemes = imageSchemes;
    }

    //геттер и сеттеры
    public Long getId(){
        return id;
    }
    public Long getIdScenarios() { return idScenarios; }
    public String getImageSchemes(){
        return imageSchemes;
    }

    public void setId(Long id) {
        this.id =id;
    }
    public void setIdScenarios(Long id) { this.idScenarios = idScenarios; }
    public void setImageSchemes(String imageSchemes) {
        this.imageSchemes = imageSchemes;
    }
}
