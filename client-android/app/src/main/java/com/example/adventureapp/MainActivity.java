package com.example.adventureapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView button_start;
    private TextView button_settings;
    private TextView button_exit;
    private MediaPlayer mediaPlayer;

    private final String musicUrl = "http://10.0.2.2:8080/audio/music.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Находим кнопки по ID
        button_start = findViewById(R.id.button_start);
        button_settings = findViewById(R.id.button_settings);
        button_exit = findViewById(R.id.button_exit);

        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllScenarioActivity.class);
                startActivity(intent);
            }
        });

        //Создаём обработчик событий, внутри обработчика вызывается функция
        button_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        //Воспроизведение музыки (если разрешено в настройках)
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        boolean musicEnabled = prefs.getBoolean("music_enabled", true);
        if (musicEnabled) {
            startMusic();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



    }

    private void startMusic() {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(musicUrl);
            mediaPlayer.setLooping(true);
            mediaPlayer.setOnPreparedListener(MediaPlayer::start);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        boolean musicEnabled = prefs.getBoolean("music_enabled", true);

        if (mediaPlayer != null) {
            if (musicEnabled && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            } else if (!musicEnabled && mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

//для обработки текстового поля при отправке номера абазаца
        //if(название элемента, который я искала по id().getText().toString().trim().equals(""))
        //Toast.makeText(MainActivity.this, "Hello", Toast.LENGTH_LONG).show();