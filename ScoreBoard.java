package com.example.Cricket;

import java.util.ArrayList;

class Batsman{
    Integer runsScored;
    Integer ballsPlayed;
    Batsman(Player player){
        runsScored = player.getRunsScored();
        ballsPlayed = player.getBowlsPlayed();
    }

    public Integer getRunsScored() {
        return runsScored;
    }

    public Integer getBallsPlayed() {
        return ballsPlayed;
    }
}
class Bowler{
    Integer wicketsTaken;
    Integer oversBowled;
    Integer maidenOvers;

    public Bowler(Player player){
        wicketsTaken = player.getWicketsTaken();
        oversBowled = player.getOversBowled();
        maidenOvers = player.getOversBowled();
    }
    public Integer getWicketsTaken() {
        return wicketsTaken;
    }

    public Integer getOversBowled() {
        return oversBowled;
    }

    public Integer getMaidenOvers() {
        return maidenOvers;
    }
}
class BattingScoreCard{
    ArrayList<Batsman> batsmen = new ArrayList<>();

  public BattingScoreCard(Team team){
      for(int i=0; i<team.getTeam().size(); i++)
          batsmen.add(new Batsman(team.getTeam().get(i)));
    }

    public ArrayList<Batsman> getBatsmen() {
        return batsmen;
    }
}
class BowlingScoreCard{
    ArrayList<Bowler> bowlers = new ArrayList<>();
    public BowlingScoreCard(Team team){
        for(int i=0; i<team.getBowlers().size(); i++)
            bowlers.add(new Bowler(team.getBowlers().get(i)));
    }

    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }
}
public class ScoreBoard{
    BattingScoreCard batingTeam1;
    BowlingScoreCard bowlingTeam1;
    BattingScoreCard batingTeam2;
    BowlingScoreCard bowlingTeam2;
    public ScoreBoard(OdiMatch odiMatch){
        batingTeam1 = new BattingScoreCard(odiMatch.getTeam1());
        bowlingTeam1 = new BowlingScoreCard(odiMatch.getTeam2());
        batingTeam2 = new BattingScoreCard(odiMatch.getTeam2());
        bowlingTeam2 = new BowlingScoreCard(odiMatch.getTeam1());
    }

    public BattingScoreCard getBatingTeam1() {
        return batingTeam1;
    }

    public BowlingScoreCard getBowlingTeam1() {
        return bowlingTeam1;
    }

    public BattingScoreCard getBatingTeam2() {
        return batingTeam2;
    }

    public BowlingScoreCard getBowlingTeam2() {
        return bowlingTeam2;
    }
}