package com.example.adventureapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ScenarioApi {
    @GET("/api/scenarios")
    Call<List<Scenario>> getAllScenarios();
}
