package david.naessens.app;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The type Master.
 */
public class Master extends Competition {

    private final ArrayList<Group> groups;
    private final ArrayList<League> leagues;
    private final ArrayList<Competitor> finalists;
    private final int nbOut;
    private final int nbGroups;
    private Competitor winner;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     * @param nbGroups    the nb groups
     * @param nbOut       the nb out
     */
    public Master(List<Competitor> competitors, int nbGroups, int nbOut) {
        super(competitors);
        this.nbOut = nbOut;
        this.finalists = new ArrayList<>();
        this.leagues = new ArrayList<>();
        this.groups = new ArrayList<>();
        this.nbGroups = nbGroups;
    }

    public ArrayList<Competitor> getFinalists() {
        return finalists;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public Competitor getWinner() {
        return winner;
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

    public void initMasterGroupsStage() {
        initGroups();
        fillGroups();
        initLeagues();
    }

    private void initLeagues(ArrayList<Group> groups) {
        for (Group group : groups) {
            League competition = new League(group.getCompetitors());
            this.leagues.add(competition);
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

    private void generateGroups(int nbGroups) {
        for (int i = 0; i < nbGroups; i++) {
            Group group = new Group();
            this.groups.add(group);
        }
    }

    /**
     * Play groups.
     */
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

    /**
     * Init finalists.
     */
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

    /**
     * Play tournament.
     */
    public void playTournament(){
        Tournament tournament = new Tournament(finalists);
        tournament.play();
        winner = tournament.getCompetitorsRemaining().get(0);
    }

    @Override
    public void play() {
        playGroups();
        initFinalists();
        playTournament();
    }
}
