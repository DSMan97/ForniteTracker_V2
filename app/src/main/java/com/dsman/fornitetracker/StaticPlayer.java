package com.dsman.fornitetracker;

class StaticPlayer {
    private EpicUserData score;
    private EpicUserData scorePerMatch;
    private EpicUserData matches;
    private EpicUserData kills;

    public EpicUserData getScore() {
        return score;
    }

    public void setScore(EpicUserData score) {
        this.score = score;
    }

    public EpicUserData getScorePerMatch() {
        return scorePerMatch;
    }

    public void setScorePerMatch(EpicUserData scorePerMatch) {
        this.scorePerMatch = scorePerMatch;
    }

    public EpicUserData getMatches() {
        return matches;
    }

    public void setMatches(EpicUserData matches) {
        this.matches = matches;
    }

    public EpicUserData getKills() {
        return kills;
    }

    public void setKills(EpicUserData kills) {
        this.kills = kills;
    }
}
