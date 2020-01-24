package com.example.Cricket;


import com.fasterxml.jackson.annotation.JsonIgnore;

class Player{

    private String name;
    private Integer runsScored = 0;
    private Integer wicketsTaken = 0;
    private Integer oversBowled = 0;
    private Integer runsConceeded = 0;
    private Integer bowlsPlayed = 0;
    private Integer maidenOvers = 0;



    Player(String name)
    {
        this.name = name;
    }
    @JsonIgnore
    public Integer getBowlsPlayed() {
        return bowlsPlayed;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public Integer getMaidenOvers() {
        return maidenOvers;
    }
    @JsonIgnore
    public Integer getRunsScored() {
        return runsScored;
    }
    @JsonIgnore
    public Integer getOversBowled() {
        return oversBowled;
    }

    @JsonIgnore
    public Integer getWicketsTaken() {
        return wicketsTaken;
    }
    public void concedeRuns(Integer runs){
        runsConceeded += runs;
    }

    public void maidenOverBowled(){
        maidenOvers++;
    }

    public void scoreRuns(Integer runs){
        runsScored += runs;
    }
    public void takeWicket(){
        wicketsTaken++;
    }
    public void bowlOver(){
        oversBowled++;
    }
    public void playBall(){
        bowlsPlayed++;
    }

    @JsonIgnore
    public Integer getRunsConceeded() {
        return runsConceeded;
    }


}
