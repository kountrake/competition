package david.naessens.app.competition;


import david.naessens.app.competition.component.Competitor;
import david.naessens.app.competition.component.GroupStage;
import david.naessens.app.competitorsselector.CompetitorsSelector;

import java.util.ArrayList;


/**
 * The type Master.
 */
public class Master extends Competition {

    private final GroupStage groupStage;
    private final CompetitorsSelector competitorsSelector;
    private Competitor winner;
    private ArrayList<Competitor> finalists;
    private Tournament tournament;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors         the competitors
     * @param nbGroups            the number of groups for the group stage
     * @param competitorsSelector the way competitors are selected from group stage to the play-off
     */
    public Master(ArrayList<Competitor> competitors, int nbGroups, CompetitorsSelector competitorsSelector) {
        super(competitors);
        this.competitorsSelector = competitorsSelector;
        this.groupStage = new GroupStage(competitors, nbGroups);
    }

    /**
     * Gets the group stage.
     *
     * @return the group stage
     */
    public GroupStage getGroupStage() {
        return groupStage;
    }

    /**
     * Gets the winner.
     *
     * @return the winner
     */
    public Competitor getWinner() {
        return winner;
    }

    /**
     * Sets the finalists.
     */
    public void setFinalists() {
        this.finalists = competitorsSelector.initFinalists(groupStage);
    }

    /**
     * Play tournament.
     */
    public void playTournament() {
        tournament = new Tournament(finalists);
        tournament.play();
        winner = tournament.getCompetitorsRemaining().get(0);
    }

    @Override
    public void play() {
        groupStage.play();
        setFinalists();
        playTournament();
    }

    /**
     * Master summary string.
     *
     * @return the string
     */
    public String masterSummary() {
        return getGroupStage().ranksGroupStageToString() + "\n\n" + this.tournament.tournamentSummary();
    }
}
