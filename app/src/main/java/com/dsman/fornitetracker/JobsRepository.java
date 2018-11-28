package com.dsman.fornitetracker;


import io.reactivex.Observable;

public class JobsRepository {

    //Repository Creado basado en el tutorial de Retrofit2 pasando los paramentros usados
    //que son platform y epic_nickname
    private static volatile JobsRepository ourInstance = new JobsRepository();

    static JobsRepository getInstance() {
        if (ourInstance == null) {
            synchronized (JobsRepository.class) {
                if (ourInstance == null) {
                    ourInstance = new JobsRepository();
                }
            }
        }
        return ourInstance;
    }

    private JobsRepository() {
        
    }

    private JobApi mFortniteApi = JobApi.Factory();


    public Observable<EpicUser> getEpicInfo(String platform, String epic_nickname){

        return mFortniteApi.getInfoEpicUser(platform,epic_nickname);
    }
}