package com.example.Cricket;

public class OdiMatchController extends MatchController {

    // MatchController matchController;


    public void playOdiInnings(Team battingTeam,Team bowlingTeam,Team teamBattingFirst)
    {
        bowlingTeam.setBowlers();
        Player currentBatsman = battingTeam.getTeam().get(0);
        Player otherBatsman =  battingTeam.getTeam().get(1);


        for (int i = 0; i < 50; i++) {
         Player currentBowler =  bowlingTeam.getNextBowler();
            currentBowler.bowlOver();
            Integer runsThisOver = playOver(currentBatsman,otherBatsman,currentBowler,battingTeam,teamBattingFirst);
            if(runsThisOver == 0)
                currentBowler.maidenOverBowled();
            if(battingTeam.getWicketsLost() == 10)
                return;
            if(teamBattingFirst != null && battingTeam.getRunsScored() > teamBattingFirst.getRunsScored())
                return;
            Player temp = currentBatsman;
            currentBatsman = otherBatsman;
            otherBatsman = temp;
        }
    }
}