package com.dsman.fornitetracker;


public class EpicUser {
    private String accountId;
    private String platformId;
    private String platformName;
    private String platformNameLong;
    private String epicUserHandle;
    private StatsP2 stats;

    //Gettters y Setters autogenerados de los atributos
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformNameLong() {
        return platformNameLong;
    }

    public void setPlatformNameLong(String platformNameLong) {
        this.platformNameLong = platformNameLong;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

    public StatsP2 getStats() {
        return stats;
    }

    public void setStats(StatsP2 stats) {
        this.stats = stats;
    }

    //Método Autogenerado
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







