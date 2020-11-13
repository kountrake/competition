package david.naessens.app;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Group stage.
 */
public class GroupStage extends Competition {

    private final int nbGroups;
    private final ArrayList<Group> groups;
    private final ArrayList<League> leagues;

    /**
     * Instantiates a new Group stage.
     *
     * @param competitors the competitors
     * @param nbGroups    the nb groups
     */
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

    /**
     * Init groups.
     */
    public void initGroups() {
        generateGroups(this.nbGroups);
    }

    /**
     * Fill groups.
     */
    public void fillGroups() {
        fillGroups(this.competitors, this.nbGroups);
    }

    /**
     * Init leagues.
     */
    public void initLeagues() {
        initLeagues(this.groups);
    }

    /**
     * Init groups stage.
     */
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

    public void play() {
        initGroupsStage();
        playGroups();
    }

    /**
     * Gets the competitors in the nth position of each group.
     *
     * @param i the index of the competitors to select
     * @return the competitors in position
     */
    public ArrayList<Competitor> getCompetitorsInPosition(int i) {
        Group group = new Group();
        Competitor[] comps = new Competitor[group.getCompetitors().size()];
        for (League league :
                this.leagues) {
            group.addCompetitor(league.ranking().keySet().toArray(comps)[i]);
        }
        return group.orderByVictories();
    }

    /**
     * Gets groups.
     *
     * @return the groups
     */
    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    /**
     * Gets leagues.
     *
     * @return the leagues
     */
    public ArrayList<League> getLeagues() {
        return leagues;
    }

    /**
     * Gets competitors.
     *
     * @return the competitors
     */
    public ArrayList<Competitor> getCompetitors() {
        return new ArrayList<>(this.competitors);
    }

    /**
     * Gets the number of groups.
     *
     * @return the nb groups
     */
    public int getNbGroups() {
        return nbGroups;
    }

    /**
     * Ranks group stage to string.
     *
     * @return the string
     */
    public String ranksGroupStageToString() {
        StringBuilder res = new StringBuilder();
        for (League l :
                getLeagues()) {
            res.append(l.ranksToString(l.ranking())).append("\n\n");
        }
        return res.toString();
    }
}
