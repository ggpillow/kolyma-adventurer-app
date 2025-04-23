package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Endings")
public class Ending {

    @Id
    @Column(name = "idEndings")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titleEnding")
    private String titleEnding;

    @Column(name = "endDescr")
    private String endDescr;

    //геттер и сеттеры
    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id =id;
    }

    public String getTitleEnding(){
        return titleEnding;
    }public void setTitleEnding(String titleEnding) {
        this.titleEnding = titleEnding;
    }

    public String getEndDescr(){
        return endDescr;
    }
    public void setEndDescr(String endDescr){
        this.endDescr = endDescr;
    }
}
