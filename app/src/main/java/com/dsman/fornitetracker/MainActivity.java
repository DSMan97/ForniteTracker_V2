package com.dsman.fornitetracker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    private Button startButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornite);
        startButton = findViewById(R.id.buttonStart);
        mp = MediaPlayer.create(this, R.raw.fornite);
        mp.start();
        startSearcher();
    }

    public void startSearcher(){
        startButton.setOnClickListener(v -> {
            Intent navigate = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(navigate);
            mp.stop();
        });
    }
}
