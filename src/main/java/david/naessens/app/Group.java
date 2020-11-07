package david.naessens.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Group.
 */
public class Group {
    private final ArrayList<Competitor> competitors;

    /**
     * Instantiates a new Group.
     */
    public Group(){
        competitors = new ArrayList<>();
    }

    /**
     * Add competitor.
     *
     * @param competitor the competitor
     */
    public void addCompetitor (Competitor competitor){
        competitors.add(competitor);
    }

    /**
     * Add competitors.
     *
     * @param competitors the competitors
     */
    public void addCompetitors (List<Competitor> competitors){
        this.competitors.addAll(competitors);
    }

    /**
     * Gets competitors.
     *
     * @return the competitors
     */
    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    /**
     * Order by victories the competitors of the group
     *
     * @return the array list of the competitors from the group ordered by victories
     */
    public ArrayList<Competitor> orderByVictories() {
        League league = new League(competitors);
        Competitor[] comps = new Competitor[competitors.size()];
        league.ranking().keySet().toArray(comps);
        return new ArrayList<>(Arrays.asList(comps).subList(0, competitors.size()));
    }
}
