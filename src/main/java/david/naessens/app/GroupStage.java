package david.naessens.app;

import java.util.ArrayList;
import java.util.List;

public class GroupStage extends Competition {

    private final int nbGroups;
    private final ArrayList<Group> groups;
    private final ArrayList<League> leagues;

    public GroupStage(ArrayList<Competitor> competitors, int nbGroups) {
        super(competitors);
        this.nbGroups = nbGroups;
        this.leagues = new ArrayList<>();
        this.groups = new ArrayList<>();
    }

    private void generateGroups(int nbGroups) {
        for (int i = 0; i < nbGroups; i++) {
            Group group = new Group();
            this.groups.add(group);
        }
    }

    private void fillGroups(List<Competitor> competitors, int nbGroups) {
        int competitorsPerGroup = competitors.size() / nbGroups;
        int start = 0;
        int end = competitorsPerGroup;
        for (Group group : this.groups) {
            ArrayList<Competitor> comp = new ArrayList<>(competitors.subList(start, end));
            group.addCompetitors(comp);
            start = end;
            end += competitorsPerGroup;
        }
    }

    private void initLeagues(ArrayList<Group> groups) {
        for (Group group : groups) {
            League competition = new League(group.getCompetitors());
            this.leagues.add(competition);
        }
    }

    public void initGroups() {
        generateGroups(this.nbGroups);
    }

    public void fillGroups() {
        fillGroups(this.competitors, this.nbGroups);
    }

    public void initLeagues() {
        initLeagues(this.groups);
    }

    public void initGroupsStage() {
        initGroups();
        fillGroups();
        initLeagues();
    }

    /**
     * Play groups.
     */
    public void playGroups() {
        for (League league : this.leagues) {
            league.play();
        }
    }

    public ArrayList<Competitor> getCompetitorsInPosition(int i) {
        Group group = new Group();
        Competitor[] comps = new Competitor[group.getCompetitors().size()];
        for (League league :
                this.leagues) {
            group.addCompetitor(league.ranks.keySet().toArray(comps)[i]);
        }
        return group.orderByVictories();
    }

    public void play() {
        initGroupsStage();
        playGroups();
    }

    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public ArrayList<Competitor> getCompetitors() {
        return new ArrayList<>(this.competitors);
    }

    public int getNbGroups() {
        return nbGroups;
    }
}
