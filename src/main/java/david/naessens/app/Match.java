package david.naessens.app;

/**
 * The type Match.
 */
public class Match {
    private Competitor competitor1;
    private Competitor competitor2;
    private Competitor winner;

    /**
     * Instantiates a new Match.
     *
     * @param c1 the c 1
     * @param c2 the c 2
     */
    public Match(Competitor c1, Competitor c2) {
        competitor1 = c1;
        competitor2 = c2;
        winner = null;
    }

    /**
     * Gets competitor 1.
     *
     * @return the competitor 1
     */
    public Competitor getCompetitor1() {
        return competitor1;
    }

    /**
     * Gets competitor 2.
     *
     * @return the competitor 2
     */
    public Competitor getCompetitor2() {
        return competitor2;
    }

    /**
     * Gets winner.
     *
     * @return the winner
     */
    public Competitor getWinner() {
        return winner;
    }

    /**
     * Sets winner.
     *
     * @param winner the winner
     */
    public void setWinner(Competitor winner) {
        this.winner = winner;
    }

    /**
     * Sets competitor 1.
     *
     * @param competitor1 the competitor 1
     */
    public void setCompetitor1(Competitor competitor1) {
        this.competitor1 = competitor1;
    }

    /**
     * Sets competitor 2.
     *
     * @param competitor2 the competitor 2
     */
    public void setCompetitor2(Competitor competitor2) {
        this.competitor2 = competitor2;
    }

    /**
     * Play a match.
     */
    public void play() {
        if (Math.random() < 0.5) {
            competitor1.increaseWins();
            setWinner(competitor1);
        }else {
            competitor2.increaseWins();
            setWinner(competitor2);
        }
    }


}
