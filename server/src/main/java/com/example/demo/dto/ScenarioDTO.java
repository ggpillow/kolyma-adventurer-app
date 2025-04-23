package com.example.demo.dto;

public class ScenarioDTO {
    private Long id;
    private String title;
    private String startDescr;
    private String miniDescription;
    private String imageURL;
    private String difficulty;

    public ScenarioDTO(Long id, String title, String startDescr, String miniDescription, String imageURL, String difficulty) {
        this.id = id;
        this.title = title;
        this.startDescr = startDescr;
        this.miniDescription = miniDescription;
        this.imageURL = imageURL;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getStartDescr (){
        return startDescr;
    }
    public String getMiniDescription (){
        return miniDescription;
    }
    public String getImageURL (){
        return imageURL;
    }
    public String getDifficulty (){
        return difficulty;
    }
}
