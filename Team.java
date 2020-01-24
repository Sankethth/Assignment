package com.example.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

class Team implements Comparable {
    String name;
    ArrayList<Player> team = new ArrayList<>();
    ArrayList<Player> bowlers = new ArrayList<>();
    Integer runsScored = 0;
    Integer wicketsLost = 0;
    Team(String name){
        this.name = name;
        for(int i=0; i<11; i++)
            team.add(new Player(name+"Player"+(i+1)));
    }

    @JsonIgnore
    public ArrayList<Player> getBowlers() {
        return bowlers;
    }

    @JsonIgnore
    public ArrayList<Player> getTeam() {
        return team;
    }
    void setBowlers(){

        Integer numberOfBowlers = 0;
        while (numberOfBowlers < 5)
            numberOfBowlers = ((int)(Math.random()*11));
        for(int i=0; i<numberOfBowlers; i++) {
            //bowlers.add((team.get((int) (Math.random() * 11))));
            bowlers.add((team.get((int)(Math.random()*11))));
        }
    }
    @JsonIgnore
    public String getName() {
        return name;
    }
    @JsonIgnore
    public Integer getWicketsLost(){
        return wicketsLost;
    }
    @JsonIgnore
    public Integer getRunsScored(){
        return runsScored;
    }

    void loseWicket(Player batsman,Player bowler)
    {
        wicketsLost++;
        bowler.takeWicket();
    }

    void scoreRuns(Integer runs,Player batsman,Player bowler){
        runsScored += runs;
        batsman.scoreRuns(runs);
        bowler.concedeRuns(runs);
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(runsScored,((Team)(o)).getRunsScored());
    }
    @JsonIgnore
    public Player getNextPlayer()
    {
        return team.get(wicketsLost);
    }
    @JsonIgnore
    public Player getNextBowler() {
        return bowlers.get((int)(Math.random()*bowlers.size()));
    }
}