package com.example.Cricket;

class Team implements Comparable {
    //ArrayList<Player> team = new ArrayList<>();
    Integer runsScored = 0;
    Integer wicketsLost = 0;
    //Player currentPlayer = team.get(0);
    //Player otherPlayer = team.get(1);
    public Integer getWicketsLost(){
        return wicketsLost;
    }
    public Integer getRunsScored(){
        return runsScored;
    }
    void loseWicket()
    {
        wicketsLost++;
    }
    void scoreRuns(Integer runs){
        runsScored += runs;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(runsScored,((Team)(o)).getRunsScored());
    }
}