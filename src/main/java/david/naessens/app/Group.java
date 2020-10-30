package david.naessens.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
    private final ArrayList<Competitor> competitors;

    public Group(){
        competitors = new ArrayList<>();
    }

    public void addCompetitor (Competitor competitor){
        competitors.add(competitor);
    }

    public void addCompetitors (List<Competitor> competitors){
        this.competitors.addAll(competitors);
    }

    public ArrayList<Competitor> getCompetitors() {
        return competitors;
    }

    public ArrayList<Competitor> OrderByVictories(){
        League league = new League(competitors);
        Competitor[] comps = new Competitor[competitors.size()];
        league.ranking().keySet().toArray(comps);
        return new ArrayList<>(Arrays.asList(comps).subList(0, competitors.size()));
    }
}
