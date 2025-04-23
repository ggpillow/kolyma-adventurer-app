package com.example.adventureapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.example.adventureapp.adapters.ScenarioAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AllScenarioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ScenarioAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_scenario);

        recyclerView = findViewById(R.id.scenarioRecyclerView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        loadScenarios();

    }

    private void loadScenarios() {
        ScenarioApi api = RetrofitClient.getClient().create(ScenarioApi.class);
        api.getAllScenarios().enqueue(new Callback<List<Scenario>>() {
            @Override
            public void onResponse(Call<List<Scenario>> call, Response<List<Scenario>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new ScenarioAdapter(AllScenarioActivity.this, response.body());
                    recyclerView.setAdapter(adapter);

                    //Масштаб и прозрачность при свайпе
                    adapter.attachToRecyclerView(recyclerView);

                    //Обработка клика по карточке
                    adapter.setOnScenarioClickListener(scenario -> {
                        Intent intent = new Intent(AllScenarioActivity.this, PreparationActivity.class);
                        intent.putExtra("scenarioId", scenario.getId());
                        intent.putExtra("title", scenario.getTitle());
                        intent.putExtra("description", scenario.getStartDescr());
                        intent.putExtra("difficulty", scenario.getDifficulty());
                        intent.putExtra("image", scenario.getImageURL());
                        startActivity(intent);
                    });

                }
            }

            @Override
            public void onFailure(Call<List<Scenario>> call, Throwable t) {
                //Обработка ошибки
            }
        });
    }
}