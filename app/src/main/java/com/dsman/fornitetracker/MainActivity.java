package com.dsman.fornitetracker;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    private Button start;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornite);
        start = findViewById(R.id.start);
        mp = MediaPlayer.create(this, R.raw.ben);
        mp.start();
    }

    public void start(){
        start.setOnClickListener(v -> {
            Intent navigate = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(navigate);
        });
    }
}
