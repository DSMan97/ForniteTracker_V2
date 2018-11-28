package com.dsman.fornitetracker;

import android.arch.lifecycle.MutableLiveData;

import android.arch.lifecycle.ViewModel;
import android.util.Log;
import java.util.HashMap;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class JobsViewModel extends ViewModel {

    /**
     * Está hecho con HashMap
     *
     * */
    private JobsRepository jobsRepository = JobsRepository.getInstance();
    public MutableLiveData<HashMap<Integer, EpicUserScore>> epicUserScoreHM = new MutableLiveData<>();


    public void getEpicUserJsonData(String platform, String epic_nickname) {
        HashMap<Integer, EpicUserScore> userDataHM = new HashMap<>();

        //me subscribo a mi Usuario Consultado para estar pendiente de los cambios recogidos
        //según el usuario que consulte, por eso se le pasan los parametros platform y epic_nickname
        jobsRepository.getEpicInfo(platform, epic_nickname)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<EpicUser>() {

                    //Métodos Autogenerados
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EpicUser epicUser) {


                        if (epicUser == null) {
                            userDataHM.clear();
                        }
                        /*Si los datos del Usuario Consultado no son nulos se añaden al HashMap,
                        que luego mostrará en los cardViews puesto que se guarda en el
                        mutable livedata, es necesario usar mutablelivedata, ya que
                        por cada búsqueda de usuario estos dantos varian, por eso es necesario
                        usar un observer/subscribe para que se actualicen cada vez que se recogen nuevos
                        datos del usuario consultado*/
                        else {
                            userDataHM.clear();
                            StaticPlayer mHM = epicUser.getStats().getP2();
                            userDataHM.put(0, mHM.getScore());
                            userDataHM.put(1, mHM.getScorePerMatch());
                            userDataHM.put(2, mHM.getMatches());
                            userDataHM.put(3, mHM.getKills());
                            epicUserScoreHM.postValue(userDataHM);
                        }

                    }

                    //Métodos Autogenerados
                    @Override
                    public void onError(Throwable e) {
                        Log.d("Service Fail", "err: " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Completado", "Datos Consultados con exito");

                    }
                });
    }
}
