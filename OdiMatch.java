package com.example.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Comparator;



class OdiMatch{
    public Team team1 = new Team("India");
    public Team team2 = new Team("Australia");
    String result;
    String scoreBoard;

    OdiMatchController odiMatchController = new OdiMatchController();
    //.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);


   /* public void setScoreBoard(OdiMatch odiMatch){
        scoreBoard = team1.getName()+" Batting</br>";
        scoreBoard+= "Name&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspRuns Scored&nbsp&nbspDeliveries Played</br>";
        ArrayList<Player> players = odiMatch.getTeam1().getTeam();
        for(int i=0; i<players.size(); i++)
        {
            scoreBoard += players.get(i).getName()+"\t"+players.get(i).getRunsScored()+"&nbsp&nbsp&nbsp"+players.get(i).getBowlsPlayed()+"</br>";
        }
        scoreBoard += team2.getName()+" Bowling\n";
        scoreBoard += "Name\tOvers Bowled\tWickets Taken\tMaiden Overs Bowled\t";
        ArrayList<Player> bowlers = odiMatch.getTeam2().getBowlers();
        for(int i=0; i<bowlers.size(); i++)
        {
            scoreBoard += bowlers.get(i).getName()+"\t"+bowlers.get(i).getWicketsTaken()+"\t"+bowlers.get(i).getMaidenOvers()+"</br>";
        }
        scoreBoard += team2.getName()+"Batting\n";
        ArrayList<Player> players2 = odiMatch.getTeam2().getTeam();
        for(int i=0; i<players2.size(); i++)
        {
            scoreBoard += players2.get(i).getName()+"\t"+players2.get(i).getRunsScored()+"\t"+players2.get(i).getBowlsPlayed()+"</br>";
        }
        scoreBoard += team2.getName()+" Bowling\n";
        scoreBoard += "Name\tOvers Bowled\tWickets Taken\tMaiden Overs Bowled\t";
        ArrayList<Player> bowlers2 = odiMatch.getTeam1().getBowlers();
        for(int i=0; i<bowlers2.size(); i++)
        {
            scoreBoard += bowlers2.get(i).getName()+"\t"+bowlers2.get(i).getWicketsTaken()+"\t"+bowlers2.get(i).getMaidenOvers()+"</br>";
        }

        scoreBoard += result;

    }

    public String getScoreBoard() {
        return scoreBoard;
    }*/

    public String getResult() {
        return result;
    }

    @JsonIgnore
    public Team getTeam1() {
        return team1;
    }

    @JsonIgnore
    public Team getTeam2() {
        return team2;
    }
    @JsonIgnore
    public OdiMatchController getOdiMatchController() {
        return odiMatchController;
    }
    public OdiMatch startMatch(){
        //System.out.println("Match Started");
        odiMatchController.playOdiInnings(team1,team2,null);
        //System.out.println("TeamA score "+team1.getRunsScored());
        odiMatchController.playOdiInnings(team2,team1,team1);
       // System.out.println("TeamB score "+team2.getRunsScored());
        if(team1.compareTo(team2) > 0)
            result =team1.getName()+" beats "+team2.getName();
        else if(team1.compareTo(team2) == 0)
            result = team1.getName()+" beats "+team2.getName();
        else if(team1.compareTo(team2) < 0)
            result = team2.getName()+" beats "+team1.getName();
      /* if(team1.compareTo(team2) > 0)
           return "Team1";
        if(team1.compareTo(team2) == 0)
            return "Tie";
        return "Team2";*/
      return this;

    }
}

