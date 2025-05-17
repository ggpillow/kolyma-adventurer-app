package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Epigraphs")
public class Epigraphs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quote;
    private String imageEpigraphs;

    public Long getId() {
        return id;
    }
    public String getQuote() {
        return quote;
    }
    private String getImageEpigraphs() {
        return imageEpigraphs;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setQuote(String quote){
        this.quote = quote;
    }
    public void setImageEpigraphs(String imageEpigraphs) {
        this.imageEpigraphs = imageEpigraphs;
    }
}
