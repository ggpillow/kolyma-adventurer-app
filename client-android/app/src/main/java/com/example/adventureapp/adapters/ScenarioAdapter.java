package com.example.adventureapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.adventureapp.R;
import com.example.adventureapp.Scenario;

import java.util.List;

public class ScenarioAdapter extends RecyclerView.Adapter<ScenarioAdapter.ScenarioViewHolder> {
    private final List<Scenario> scenarioList;
    private final Context context;

    //обработчик клика
    public interface OnScenarioClickListener {
        void onScenarioClick(Scenario scenario);
    }

    private OnScenarioClickListener listener;

    public void setOnScenarioClickListener(OnScenarioClickListener listener){
        this.listener = listener;
    }

    public ScenarioAdapter(Context context, List<Scenario> scenarioList) {
        this.scenarioList = scenarioList;
        this.context = context;
    }

    @NonNull
    @Override
    public ScenarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_scenario_card, parent, false);
        return new ScenarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScenarioViewHolder holder, int position) {
        Scenario scenario = scenarioList.get(position);

        holder.title.setText(scenario.getTitle());
        holder.miniDescription.setText(scenario.getMiniDescription());
        holder.difficulty.setText(scenario.getDifficulty());

        Glide.with(context)
                .load(scenario.getImageURL())
                .into(holder.image);

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onScenarioClick(scenario);
            }
        });
    }

    @Override
    public int getItemCount() {
        return scenarioList.size();
    }

    //подключаемся к RecyclerView для масштабирования при прокрутке
    public void attachToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView rv, int dx, int dy) {
                float center = rv.getWidth() / 2f;

                for (int i = 0; i < rv.getChildCount(); i++) {
                    View child = rv.getChildAt(i);
                    float childCenter = (child.getLeft() + child.getRight()) / 2f;
                    float distanceFromCenter = Math.abs(center - childCenter);

                    float scale = 1 - (distanceFromCenter / center) * 0.2f;
                    float alpha = 1 - (distanceFromCenter / center) * 0.4f;

                    child.setScaleX(Math.max(scale, 0.8f));
                    child.setScaleY(Math.max(scale, 0.8f));
                    child.setAlpha(Math.max(alpha, 0.5f));
                }
            }
        });
    }

    public static class ScenarioViewHolder extends RecyclerView.ViewHolder {
        TextView title, miniDescription, difficulty;
        ImageView image;

        public ScenarioViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.scenario_title);
            miniDescription = itemView.findViewById(R.id.scenario_description);
            difficulty = itemView.findViewById(R.id.scenario_difficulty);
            image = itemView.findViewById(R.id.scenario_image);
        }
    }
}