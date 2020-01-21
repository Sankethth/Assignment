package com.example.Cricket;

import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Comparator;



class OdiMatch{
    Team team1 = new Team();
    Team team2 = new Team();

    OdiMatchController odiMatchController = new OdiMatchController();
    //.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);


    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public OdiMatchController getOdiMatchController() {
        return odiMatchController;
    }

    public String startMatch(){
        //System.out.println("Match Started");
        odiMatchController.playOdiInnings(team1,null);
        System.out.println("TeamA score "+team1.getRunsScored());
        odiMatchController.playOdiInnings(team2,team1);
        System.out.println("TeamB score "+team2.getRunsScored());
       if(team1.compareTo(team2) > 0)
           return "Team1";
        if(team1.compareTo(team2) == 0)
            return "Tie";
        return "Team2";

    }
}

