package com.example.Cricket;

public class MatchController
{
    Integer getRunsOrWicket()
    {
        return (int) (Math.random()*7);
    }
    void playOver(Team team,Team teamBattingFirst){
        for(int i=0; i<6; i++) {
            Integer runsThisBall = getRunsOrWicket();
            if(runsThisBall > 6) {   //An Invalid run implies a Wicket
                team.loseWicket();
                if (team.getWicketsLost() == 10)
                    return;
            }
            else {
                team.scoreRuns(runsThisBall);
            }
            if(teamBattingFirst != null && team.getRunsScored() > teamBattingFirst.getRunsScored())
                return;
        }
    }
}
