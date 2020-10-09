package app;


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
     *
     * @param c                    the c
     * @param competitorsRemaining the competitors remaining
     */
    public void oddCompetitors(List<Competitor> c, ArrayList<Competitor> competitorsRemaining) {
        if (c.size() % 2 != 0) {
            competitorsRemaining.add(c.get(0));
            c.remove(0);
        }
    }

    /**
     * Play a round.
     *
     * @param c                    the c
     * @param competitorsRemaining the competitors remaining
     */
    public void playARound(List<Competitor> c, ArrayList<Competitor> competitorsRemaining) {
        for (int i = 1; i < c.size(); i += 2) {
            playAMatch(c, i);
            winnerOfTheMatch(c, competitorsRemaining, i);
        }
    }

    /**
     * Winner of the match.
     *
     * @param c                    the c
     * @param competitorsRemaining the competitors remaining
     * @param i                    the
     */
    public void winnerOfTheMatch(List<Competitor> c, ArrayList<Competitor> competitorsRemaining, int i) {
        if (match.getCompetitor1().getWins() == 1) {
            competitorsRemaining.add(c.get(i - 1));
            match.getCompetitor1().increaseWins();
        } else {
            competitorsRemaining.add(c.get(i));
            match.getCompetitor2().increaseWins();
        }
    }

    /**
     * Play a match.
     *
     * @param c the c
     * @param i the
     */
    public void playAMatch(List<Competitor> c, int i) {
        match.setCompetitor1(c.get(i - 1));
        match.setCompetitor1(c.get(i));
        match.play();
    }

    /**
     * Process competitor.
     *
     * @param c the c
     * @return the competitor
     */
    public Competitor process(List<Competitor> c) {
        if (c.size() == 1) {
            return c.get(0);
        }
        oddCompetitors(c, competitorsRemaining);
        playARound(c, competitorsRemaining);
        return process(competitorsRemaining);
    }

    @Override
    public void play() {
        process(competitors);
    }
}
