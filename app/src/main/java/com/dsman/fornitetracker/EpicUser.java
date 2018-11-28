package com.dsman.fornitetracker;


public class EpicUser {
    private String accountId;
    private String platformId;
    private String platformName;
    private String platformNameLong;
    private String epicUserHandle;
    private StatsP2 stats;

    //Haciendolo de cero me he dado cuenta que solo necesito recoger los stats

    public StatsP2 getStats() {
        return stats;
    }


    //Método Autogenerado (conversión a formato Json)
    @Override
    public String toString() {
        return "EpicUser{" +
                "accountId='" + accountId + '\'' +
                ", platformId='" + platformId + '\'' +
                ", platformName='" + platformName + '\'' +
                ", platformNameLong='" + platformNameLong + '\'' +
                ", epicUserHandle='" + epicUserHandle + '\'' +
                ", statics=" + stats +
                '}';
    }
}







