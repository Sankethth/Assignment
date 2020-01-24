package com.example.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public abstract class MatchController
{
    String thisMatch="match";


    public String getThisMatch() {
        return thisMatch;
    }

    Integer getRunsOrWicket()
    {
        ArrayList<Integer> runs= new ArrayList<>();
        for(int i=0; i<30; i++)
            runs.add(0);
        for (int i=0; i<30; i++)
            runs.add(1);
        for(int i=0; i<30; i++)
            runs.add(2);
        for (int i=0; i<10; i++)
            runs.add(3);
        for(int i=0; i<25; i++)
            runs.add(4);
        for(int i=0; i<5; i++)
            runs.add(5);
        for (int i=0; i<20; i++)
            runs.add(6);
        for(int i=0; i<15; i++)
            runs.add(7);
        for(int i=0; i<20; i++)
            runs.add(8);
        return runs.get((int) (Math.random()*runs.size()));
    }
    Integer playOver(Player currentBatsman, Player otherBatsman, Player bowler, Team team, Team teamBattingFirst){
        bowler.bowlOver();
        Integer runsThisOver = 0;
        for(int i=0; i<6; i++) {
            currentBatsman.playBall();
            Integer runsThisBall = getRunsOrWicket();
            if(runsThisBall > 6) {   //An Invalid run implies a Wicket or an extra
                team.loseWicket(currentBatsman,bowler);
                if (team.getWicketsLost() == 10)
                    return runsThisOver;
                currentBatsman = team.getNextPlayer();
            }
            else {
                runsThisOver += runsThisBall;
                team.scoreRuns(runsThisBall,currentBatsman,bowler);
                if((runsThisBall%2) == 1){
                    Player temp = currentBatsman;
                     currentBatsman = otherBatsman;
                    otherBatsman = temp;
            }
            if(teamBattingFirst != null && team.getRunsScored() > teamBattingFirst.getRunsScored())
                return runsThisOver;
        }
    }
        return runsThisOver;
    }

    void switchPlayers(Player currentBatsman, Player otherBatsman) {
        Player temp = currentBatsman;
        currentBatsman = otherBatsman;
        otherBatsman = temp;
    }
}
