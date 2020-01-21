package com.example.Cricket;

public class OdiMatchController extends MatchController {

    // MatchController matchController;

    public void playOdiInnings(Team team,Team teamBattingFirst)
    {

        for (int i = 0; i < 50; i++) {
            playOver(team,teamBattingFirst);
            if(team.getWicketsLost() == 10)
                return;
            if(teamBattingFirst != null && team.getRunsScored() > teamBattingFirst.getRunsScored())
                return;
        }
    }
}