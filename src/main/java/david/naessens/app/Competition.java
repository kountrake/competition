package david.naessens.app;

import david.naessens.util.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Competition.
 */
public abstract class Competition {

    /**
     * The Match.
     */
    protected final Match match;
    /**
     * The Competitors.
     */
    protected final List<Competitor> competitors;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     */
    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        this.match = new Match(competitors.get(0), competitors.get(1));
    }

    /**
     * Play the competition.
     */
    public void play() {
        play(competitors);
    }

    /**
     * Play.
     *
     * @param competitors the competitors
     */
    protected void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size() - 1; i++) {
            matchesAgainstOthers(competitors, i);
        }
    }

    /**
     * Matches against others.
     *
     * @param competitors the competitors
     * @param i           the
     */
    protected void matchesAgainstOthers(List<Competitor> competitors, int i) {
        for (int j = i + 1; j < competitors.size(); j++) {
            playMatch(competitors.get(i), competitors.get(j));
        }
    }

    /**
     * Play match.
     *
     * @param c1 the c 1
     * @param c2 the c 2
     */
    protected void playMatch(Competitor c1, Competitor c2){
        match.setCompetitor1(c1);
        match.setCompetitor2(c2);
        match.play();
    }

    /**
     * Ranking map.
     *
     * @return the map
     */
    public Map<Competitor, Integer> ranking() {
        HashMap<Competitor, Integer> ranks = new HashMap<>();
        for (Competitor c : competitors) {
            ranks.put(c, c.getWins());
        }
        return MapUtil.sortByDescendingValue(ranks);
    }

}
