package com.dsman.fornitetracker;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.arch.lifecycle.ViewModelProviders;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.HashMap;




public class HomeActivity extends AppCompatActivity {


    private JobsViewModel mViewModel;
    private FloatingActionButton btnSearch;
    private Spinner spPlatform;
    private String mPlatform;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        spPlatform = findViewById(R.id.spPlatform);

        //Método Botón
        btnSearch = findViewById(R.id.search_button);
        clickSearchButton();

        //Método de Actualización de Vista pasando los atributos vacios;
        viewUpdater("", "");

        //Método Generador de Anuncios (Google AdMob)
        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8891074301414208/7704547084");
        MobileAds.initialize(this, "ca-app-pub-8891074301414208~8516857886");
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    public void platformChanger(){
         mPlatform = spPlatform.getSelectedItem().toString();
        if(mPlatform.equals("PC")){
            mPlatform = "pc";
        }
        if(mPlatform.equals("PS4")){
            mPlatform = "psn";
        }
        if(mPlatform.equals("Xbox")){
            mPlatform = "xbl";
        }
    }
    public void getAllData() {
        EditText fortniteUser = findViewById(R.id.userName);
        platformChanger();
        String mEpicUserName = fortniteUser.getText().toString();
        mViewModel.getEpicUserJsonData(mPlatform, mEpicUserName);
    }

    public void clickSearchButton() {
        btnSearch.setOnClickListener(v -> {
            getAllData();
        });
    }

    public void viewUpdater(String platform, String epic_nickname) {
        mViewModel = ViewModelProviders.of(this).get(JobsViewModel.class);
        mViewModel.epicUserScoreHM.observe(this, epicUserScoreHashMap -> {

            if (!epicUserScoreHashMap.isEmpty()) {
                forniteHashMapGenerator(epicUserScoreHashMap);
            }
        });

        mViewModel.getEpicUserJsonData(platform, epic_nickname);
    }

    public void forniteHashMapGenerator(HashMap<Integer,EpicUserScore> jsonHM) {
        RecyclerView mRecyclerView = findViewById(R.id.f_recyclerView);
        ForniteAdapter fAdapter = new ForniteAdapter(jsonHM);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(fAdapter);
    }


}