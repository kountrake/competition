package david.naessens.app;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Master extends Competition {

    private final ArrayList<Group> groups;
    private final ArrayList<League> leagues;
    private final ArrayList<Competitor> finalists;
    private final int nbOut;
    private Competitor winner;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     */
    public Master(List<Competitor> competitors, int nbGroups, int nbOut) {
        super(competitors);
        this.nbOut = nbOut;
        this.finalists = new ArrayList<>();
        this.leagues = new ArrayList<>();
        groups = new ArrayList<>();
        generateGroups(nbGroups);
        fillGroups(competitors, nbGroups);
        initLeagues(this.groups);
    }

    private void initLeagues(ArrayList<Group> groups) {
        for (Group group : this.groups) {
            League competition = new League(group.getCompetitors());
            this.leagues.add(competition);
        }
    }

    private void fillGroups(List<Competitor> competitors, int nbGroups) {
        int competitorsPerGroup = competitors.size() / nbGroups;
        int start = 0;
        int end = competitorsPerGroup;
        for (Group group : this.groups) {
            ArrayList<Competitor> comp = (ArrayList<Competitor>) competitors.subList(start, end);
            group.addCompetitors(comp);
            start = end;
            end += competitorsPerGroup;
        }
    }

    private void generateGroups(int nbGroups) {
        for (int i = 0; i < nbGroups; i++) {
            Group group = new Group();
            this.groups.add(group);
        }
    }

    public void playGroups(){
        for (League league : this.leagues) {
            league.play();
        }
    }

    private ArrayList<Competitor> getCompetitorsInPosition(int i){
        Group group = new Group();
        Competitor[] comps = new Competitor[group.getCompetitors().size()];
        for (League league :
                this.leagues) {
            group.addCompetitor(league.ranks.keySet().toArray(comps)[i]);
        }
        return group.OrderByVictories();
    }

    public void initFinalists(){
        int cpt = 1;
        int position = 1;
        int i = 0;
        ArrayList<Competitor> comps = getCompetitorsInPosition(0);
        while(cpt<=this.nbOut){
            if (i >= comps.size()){
                comps = getCompetitorsInPosition(position);
                position++;
                i = 0;
            }
            finalists.add(comps.get(i));
            cpt++;
        }
        Collections.shuffle(finalists);
    }

    public void playTournament(){
        Tournament tournament = new Tournament(finalists);
        tournament.play();
        winner = tournament.getCompetitorsRemaining().get(0);
    }
}
