package app;

public class Match {
    private Competitor competitor1;
    private Competitor competitor2;
    private Competitor winner;

    public Match(Competitor c1, Competitor c2) {
        competitor1 = c1;
        competitor2 = c2;
    }

    public Competitor getCompetitor1() {
        return competitor1;
    }

    public Competitor getCompetitor2() {
        return competitor2;
    }

    public Competitor getWinner() {
        return winner;
    }

    public void setWinner(Competitor winner) {
        this.winner = winner;
    }

    public void setCompetitor1(Competitor competitor1) {
        this.competitor1 = competitor1;
    }

    public void setCompetitor2(Competitor competitor2) {
        this.competitor2 = competitor2;
    }

    public void play() {
        if (Math.random() < 0.5) {
            competitor1.setWins(competitor1.getWins() + 1);
        }
        competitor1.setWins(competitor1.getWins() + 1);
    }


}
