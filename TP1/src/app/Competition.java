package app;

import util.MapUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Competition {

    protected final Match match;
    protected final List<Competitor> competitors;

    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        this.match = new Match(competitors.get(0), competitors.get(1));
    }

    public void play() {
        play(competitors);
    }

    protected void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size() - 1; i++) {
            matchesAgainstOthers(competitors, i);
        }
    }

    protected void matchesAgainstOthers(List<Competitor> competitors, int i) {
        for (int j = i + 1; j < competitors.size(); j++) {
            playMatch(competitors.get(i), competitors.get(j));
        }
    }

    protected void playMatch(Competitor c1, Competitor c2){
        match.setCompetitor1(c1);
        match.setCompetitor2(c2);
        match.play();
    }

    public Map<Competitor, Integer> ranking() {
        HashMap<Competitor, Integer> ranks = new HashMap<>();
        for (Competitor c : competitors) {
            ranks.put(c, c.getWins());
        }
        return MapUtil.sortByDescendingValue(ranks);
    }

}
