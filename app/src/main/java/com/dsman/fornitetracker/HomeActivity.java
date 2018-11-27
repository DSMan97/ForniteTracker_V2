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

import java.util.List;

public class HomeActivity extends AppCompatActivity {


    private EditText nick_name_fornite;
    private Spinner spinner_platform;
    private ForniteAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnSearch;
    private JobsViewModel epicViewModel;
    private String platform;
    private String epic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nick_name_fornite = findViewById(R.id.nick_name_fornite);
        spinner_platform = findViewById(R.id.spinner_plataform);
        btnSearch = findViewById(R.id.gobtn);
        changeData("","");

        clickSearchButton();

    }


    public void changeData(String platform,String epic_nickname){
        epicViewModel = ViewModelProviders.of(this).get(JobsViewModel.class);
        epicViewModel.epicUserData.observe(this, epicUserData -> {
            if(epicUserData!=null){
                generateForniteList(epicUserData);
            }
        });
        epicViewModel.getData(platform, epic_nickname);
    }

    public void generateForniteList(List<EpicUserData> listFornite) {
        recyclerView = findViewById(R.id.recycleview_fornite);
        adapter = new ForniteAdapter(listFornite);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

  public void clickSearchButton(){
        btnSearch.setOnClickListener(v -> {
            platform = spinner_platform.getSelectedItem().toString();
            epic_nickname = nick_name_fornite.getText().toString();
            epicViewModel.getData(platform, epic_nickname);
        });
    }

}