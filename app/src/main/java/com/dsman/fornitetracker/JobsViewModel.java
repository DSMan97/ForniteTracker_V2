package com.dsman.fornitetracker;

import android.arch.lifecycle.MutableLiveData;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JobsViewModel extends ViewModel {

    private JobsRepository jobsRepository = JobsRepository.getInstance();
    public MutableLiveData<List<EpicUserData>> epicUserData = new MutableLiveData<>();
    public List<EpicUserData> epicDataList = new ArrayList<>();


    public void getData(String platform, String epic_nickname){

        //me subscribo a mi Usuario Consultado
        jobsRepository.getEpicInfo(platform,epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<EpicUser>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EpicUser epicObject) {

                        //si los datos del Usuario Consultado no están vacios se añaden a la lista
                        if(epicObject!=null) {
                            epicDataList.clear();
                            StaticPlayer data = epicObject.getStats().getP2();
                            epicDataList.add(data.getScore());
                            epicDataList.add(data.getScorePerMatch());
                            epicDataList.add(data.getMatches());
                            epicDataList.add(data.getKills());
                            epicUserData.postValue(epicDataList);
                        }
                    }

                    //Métodos Autogenerados
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Service Fail","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}