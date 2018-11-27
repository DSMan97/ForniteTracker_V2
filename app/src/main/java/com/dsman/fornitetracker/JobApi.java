package com.dsman.fornitetracker;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface JobApi {

    @Headers("TRN-Api-Key: 45db49f2-227b-47a6-a30a-21860a82e52b")
    @GET("v1/profile/{platform}/{epic-nickname}")
    Observable<EpicUser> getInfoEpicUser(@Path("platform") String platform , @Path("epic-nickname") String epic_nickname);


    static JobApi Factory() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(JobApi.class);
    }
}