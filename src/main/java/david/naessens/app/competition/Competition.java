package david.naessens.app.competition;

import david.naessens.app.competition.component.Competitor;
import david.naessens.app.competition.component.Match;
import david.naessens.app.sportObserver.SportObserver;
import david.naessens.util.MapUtil;

import java.util.ArrayList;
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
     * The Sport observers
     */
    protected final ArrayList<SportObserver> sportObservers;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     */
    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        this.match = new Match(competitors.get(0), competitors.get(1));
        sportObservers = new ArrayList<>();
    }

    /**
     * Add sport observer.
     *
     * @param sportObserver the sport observer
     */
    public void addSportObserver(SportObserver sportObserver) {
        this.sportObservers.add(sportObserver);
    }


    /**
     * Add sport observers.
     *
     * @param sportObservers the sport observers
     */
    public void addSportObservers(List<SportObserver> sportObservers) {
        this.sportObservers.addAll(sportObservers);
    }


    /**
     * Remove sport observer.
     *
     * @param sportObserver the sport observer
     */
    public void removeSportObserver(SportObserver sportObserver) {
        this.sportObservers.remove(sportObserver);
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
    public void play(List<Competitor> competitors) {
        for (int i = 0; i < competitors.size() - 1; i++) {
            matchesAgainstOthers(competitors, i);
        }
    }

    /**
     * Matches against others.
     *
     * @param competitors the competitors
     * @param i           the index of the players to be be chosen for the match
     */
    public void matchesAgainstOthers(List<Competitor> competitors, int i) {
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
    public void playMatch(Competitor c1, Competitor c2) {
        match.setCompetitor1(c1);
        match.setCompetitor2(c2);
        match.play();
        if (sportObservers.size() > 0)
            System.out.println("---------------\n| New Match : |\n--------------- \n");
        updateSportObservers();
    }

    private void updateSportObservers() {
        Competitor winner = match.getWinner();
        Competitor looser = match.getLooser();
        for (SportObserver so : sportObservers) {
            so.notifyMatchResult(winner, looser);
        }
    }

    /**
     * Play match using the strength of each competitor.
     *
     * @param c1 the competitor 1
     * @param c2 the competitor 2
     */
    public void playMatchWithStrength(Competitor c1, Competitor c2) {
        match.setCompetitor1(c1);
        match.setCompetitor2(c2);
        match.playWithStrength();
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

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("| Competition Ranking |\n"
                + "_______________________\n");
        for (Competitor competitor :
                competitors) {
            res.append(competitor.getName()).append(" | ").append(competitor.getWins()).append("\n");
        }
        return res.toString();
    }
}
