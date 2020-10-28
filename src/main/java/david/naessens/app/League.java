package david.naessens.app;

import java.util.HashMap;
import java.util.List;

/**
 * The type League.
 */
public class League extends Competition {

    /**
     * The Ranks.
     */
    public HashMap<Competitor, Integer> ranks;

    /**
     * Instantiates a new League.
     *
     * @param competitors the competitors
     */
    public League(List<Competitor> competitors) {
        super(competitors);
        ranks = new HashMap<>();
        for (Competitor c : competitors) {
            ranks.put(c, c.getWins());
        }

    }

    /**
     * Gets competitors.
     *
     * @return the competitors
     */
    public List<Competitor> getCompetitors() {
        return super.competitors;
    }

    /**
     * Gets ranks.
     *
     * @return the ranks
     */
    public HashMap<Competitor, Integer> getRanks() {
        return ranks;
    }

    public void play() {
        super.play(); //Matchs aller
        super.play(); //Matchs retour
        for (Competitor c : getCompetitors()) {
            ranks.replace(c, c.getWins());
        }
    }
}
