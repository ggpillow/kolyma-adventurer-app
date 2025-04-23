package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "scenarios")
public class Scenario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "start_descr")
    private String startDescr;

    @Column(name = "mini_description")
    private String miniDescription;

    @Column(name = "image_url")
    private String imageURL;

    @Column(name = "difficulty")
    private String difficulty;

    public Scenario() {}

    //Геттеры
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getStartDescr() {
        return startDescr;
    }
    public String getMiniDescription(){
        return miniDescription;
    }
    public String getImageURL(){
        return imageURL;
    }
    public String getDifficulty(){
        return difficulty;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStartDescr(String startDescr) {
        this.startDescr = startDescr;
    }
    public void setMiniDescription(String miniDescription) {
        this.miniDescription = miniDescription;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}