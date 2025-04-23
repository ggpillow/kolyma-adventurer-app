package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Paragraphs")
public class Paragraph {

    @Id
    @Column(name = "idParagraphs")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "paragraphNumber")
    private int paragraphNumber;

    @Column(name = "paragraphDescr")
    private String paragraphDescr;

    //геттер и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public int getParagraphNumber() {
        return paragraphNumber;
    }
    public void setParagraphNumber(int paragraphNumber) {
        this.paragraphNumber = paragraphNumber;
    }

    public String getParagraphDescr() {
        return paragraphDescr;
    }
    public void setparagraphDescr(String paragraphDescr) {
        this.paragraphDescr = paragraphDescr;
    }
}
