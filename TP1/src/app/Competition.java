package app;

import util.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Competition {

    protected final Match match;
    private final List<Competitor> competitors;

    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        this.match = new Match(competitors.get(0), competitors.get(1));
    }

    public void play() {
        play(competitors);
    }

    protected void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size() - 1; i++) {
            for (int j = i + 1; j < competitors.size(); j++) {
                match.setCompetitor1(competitors.get(i));
                match.setCompetitor2(competitors.get(j));
                match.play();
            }
        }
    }

    protected void playMatch(Competitor c1, Competitor c2) {
        this.match.setCompetitor1(c1);
        this.match.setCompetitor2(c2);
        match.play();
    }

    public Map<Competitor, Integer> ranking() {
        HashMap<Competitor, Integer> ranks = null;
        for (Competitor c : competitors) {
            ranks.put(c, c.getWins());
        }
        assert ranks != null;
        return MapUtil.sortByDescendingValue(ranks);
    }

}
