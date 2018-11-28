package com.dsman.fornitetracker;

class StaticPlayer {
    private EpicUserScore score;
    private EpicUserScore scorePerMatch;
    private EpicUserScore matches;
    private EpicUserScore kills;

    //Haciendolo de cero me he dado cuenta que solo necesito recoger los
    // atributos de la clase, no setearlos
    public EpicUserScore getScore() {
        return score;
    }


    public EpicUserScore getScorePerMatch() {
        return scorePerMatch;
    }



    public EpicUserScore getMatches() {
        return matches;
    }



    public EpicUserScore getKills() {
        return kills;
    }


}
