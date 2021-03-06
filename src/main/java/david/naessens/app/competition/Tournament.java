package david.naessens.app.competition;

import david.naessens.app.competition.component.Competitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The type Tournament.
 */
public class Tournament extends Competition {

    private final ArrayList<Competitor> competitorsRemaining;
    private final ArrayList<String> matches;

    /**
     * Instantiates a new Tournament.
     *
     * @param competitors the competitors
     */
    public Tournament(List<Competitor> competitors) {
        super(competitors);
        competitorsRemaining = new ArrayList<>();
        competitorsRemaining.addAll(competitors);
        matches = new ArrayList<>();
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
     * Play a match.
     *
     * @param c the competitors
     * @param i the index
     */
    private void playAMatch(List<Competitor> c, int i) {
        super.playMatch(c.get(i - 1), c.get(i));
        this.matches.add(c.get(i - 1).getName() + " vs " + c.get(i).getName());
    }

    /**
     * Process competitor.
     *
     * @param c the competitors
     */
    protected void process(List<Competitor> c) {
        int i = 1;
        int nbRounds = 1;
        while (c.size() != 1) {
            playAMatch(c, i);
            removeLoser();
            i = nextMatch(i, nbRounds);
            if (i >= competitorsRemaining.size()) {
                i = competitorsRemaining.size() - 1;
                nbRounds++;
            } else if (i <= 0) {
                i = 1;
                nbRounds++;
            }
        }
    }


    /**
     * Next match ordering function depending on the round number
     * -Decrease on peer round to go down the competitors list
     * -Increase on odd round to go through the competitors list
     * That way no one can be in final without playing a match.
     *
     * @param i        the index
     * @param nbRounds the number of rounds played
     * @return the index needed for the next match
     */
    private int nextMatch(int i, int nbRounds) {
        if (nbRounds % 2 == 0){
            i -= 2;
        }else{
            i++;
        }
        return i;
    }

    /**
     * Removes the loser of a match of the remaining competitors
     */
    private void removeLoser() {
        if (this.match.getWinner() == this.match.getCompetitor1()) {
            competitorsRemaining.remove(this.match.getCompetitor2());
        } else {
            competitorsRemaining.remove(this.match.getCompetitor1());
        }
    }

    @Override
    public void play() {
        process(competitorsRemaining);
    }

    /**
     * Tournament summary string.
     *
     * @return the string
     */
    public String tournamentSummary() {
        StringBuilder res = new StringBuilder(this.competitorsRemaining.get(0).getName() + " \n");
        Collections.reverse(this.matches);
        res.append(matches.get(0)).append("\n");
        int nbMatch = 2;
        int cpt = 2;
        for (int i = 1; i < matches.size(); i++) {
            res.append(matches.get(i)).append("\t");
            if (i == nbMatch) {
                cpt *= 2;
                nbMatch = nbMatch + cpt;
                res.append("\n");
            }
        }
        return res.append("\n").toString();
    }
}
