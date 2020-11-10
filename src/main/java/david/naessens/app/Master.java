package david.naessens.app;


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
     * @param groupStage          the group Stage
     * @param competitorsSelector the way competitors are selected from group stage to the play-off
     */
    public Master(GroupStage groupStage, CompetitorsSelector competitorsSelector) {
        super(groupStage.getCompetitors());
        this.competitorsSelector = competitorsSelector;
        this.groupStage = groupStage;
    }

    public GroupStage getGroupStage() {
        return groupStage;
    }

    public Competitor getWinner() {
        return winner;
    }

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

    public String masterSummary() {
        return getGroupStage().ranksGroupStageToString() + "\n\n" + this.tournament.tournamentSummary();
    }
}
