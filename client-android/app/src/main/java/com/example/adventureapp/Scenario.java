package com.example.adventureapp;

import com.google.gson.annotations.SerializedName;

public class Scenario {
    @SerializedName("idScenarios")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("startDescr")
    private String startDescr;
    @SerializedName("miniDescription")
    private String miniDescription;
    @SerializedName("imageURL")
    private String imageURL;
    @SerializedName("difficulty")
    private String difficulty;

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getMiniDescription() {
        return miniDescription;
    }
    public String getStartDescr() {
        return startDescr;
    }
    public String getImageURL() {
        return imageURL;
    }
    public String getDifficulty() {
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