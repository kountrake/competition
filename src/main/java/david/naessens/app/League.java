package david.naessens.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String ranksToString(Map<Competitor, Integer> ranks) {
        StringBuilder res = new StringBuilder("| League Ranking |\n"
                + "_______________________\n");
        for (Competitor competitor :
                ranks.keySet()) {
            res.append(competitor.getName()).append(" | ").append(competitor.getWins()).append("\n");
        }
        return res.toString();
    }
}
