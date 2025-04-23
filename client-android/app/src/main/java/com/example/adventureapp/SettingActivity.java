package com.example.adventureapp;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Switch;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private Switch switch_music;
    private Switch switch_voice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_setting);

        switch_music = findViewById(R.id.switch_music);
        switch_voice = findViewById(R.id.switch_voice);

        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        boolean isMusicEnabled = preferences.getBoolean("music_enabled", true);
        boolean isVoiceEnabled = preferences.getBoolean("voice_enabled", true);

        switch_music.setChecked(isMusicEnabled);
        switch_voice.setChecked(isVoiceEnabled);

        switch_music.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                editor.putBoolean("music_enabled", true);
                Toast.makeText(this, "Музыка включена",Toast.LENGTH_SHORT).show();
            } else {
                editor.putBoolean("music_enabled", false);
                Toast.makeText(this, "Музыка выключена", Toast.LENGTH_SHORT).show();
            }
            editor.apply();
        }));

        switch_voice.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                editor.putBoolean("voice_enabled", true);
                Toast.makeText(this, "Голос включен", Toast.LENGTH_SHORT).show();
            } else {
                editor.putBoolean("voice_enabled", false);
                Toast.makeText(this, "Голос выключен", Toast.LENGTH_SHORT).show();
            }
            editor.apply();
        });

        findViewById(R.id.button_back).setOnClickListener(v -> {
            finish(); //Закрывает настройки и возвращает в MainActivity
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}