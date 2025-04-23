package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Schemes")
public class Scheme {

    @Id
    @Column(name = "idSchemes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imageSchemes")
    private String imageSchemes;

    //геттер и сеттеры
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id =id;
    }

    public String getImageSchemes(){
        return imageSchemes;
    }
    public void setImageSchemes(String imageSchemes) {
        this.imageSchemes = imageSchemes;
    }
}
