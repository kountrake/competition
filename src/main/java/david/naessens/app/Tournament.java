package david.naessens.app;


import java.util.ArrayList;
import java.util.List;

/**
 * The type Tournament.
 */
public class Tournament extends Competition {

    private final ArrayList<Competitor> competitorsRemaining;

    /**
     * Instantiates a new Tournament.
     *
     * @param competitors the competitors
     */
    public Tournament(List<Competitor> competitors) {
        super(competitors);
        competitorsRemaining = new ArrayList<>();
    }

    /**
     * Gets competitors remaining.
     *
     * @return the competitors remaining
     */
    public ArrayList<Competitor> getCompetitorsRemaining() {
        return competitorsRemaining;
    }

    /**
     * Odd competitors.
     */
    public void oddCompetitors() {
        if (competitors.size() % 2 != 0) {
            competitorsRemaining.add(competitors.get(0));
            competitors.remove(0);
        }
    }

    /**
     * Play a round.
     *
     * @param c the competitors for the round
     */
    public void playARound(List<Competitor> c) {
        for (int i = 1; i < c.size(); i += 2) {
            playAMatch(c, i);
            winnerGoesNextRound();
        }
    }

    /**
     * Winner of the match.
     */
    public void winnerGoesNextRound() {
        competitorsRemaining.remove(this.match.getCompetitor1());
        competitorsRemaining.remove(this.match.getCompetitor2());
        competitorsRemaining.add(this.match.getWinner());
    }

    /**
     * Play a match.
     *
     * @param c the competitors
     * @param i the index
     */
    public void playAMatch(List<Competitor> c, int i) {
        match.setCompetitor1(c.get(i - 1));
        match.setCompetitor1(c.get(i));
        match.play();
    }

    /**
     * Process competitor.
     * /!\ Do not work... The Random class throw an error because of the recursive calls
     * @param c the competitors
     * @return the competitor
     */
    public Competitor process(List<Competitor> c) {
        if (c.size() == 1) {
            return c.get(0);
        }
        oddCompetitors();
        playARound(c);
        return process(competitorsRemaining);
    }

    @Override
    public void play() {
        process(competitors);
    }
}
