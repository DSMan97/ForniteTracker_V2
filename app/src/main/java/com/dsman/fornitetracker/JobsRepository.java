package com.dsman.fornitetracker;


import io.reactivex.Observable;

public class JobsRepository {

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

    private JobApi mForniteApi = JobApi.Factory();


    public Observable<EpicUser> getEpicInfo(String platform, String epic_nickname){

        return mForniteApi.getInfoEpicUser(platform,epic_nickname);
    }
}