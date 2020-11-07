package david.naessens.app;


import david.naessens.app.exceptions.NotAPowerOfTwoException;
import david.naessens.util.MathUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Master.
 */
public class Master extends Competition {

    private final GroupStage groupStage;
    private final int nbOut;
    private Competitor winner;
    private ArrayList<Competitor> finalists;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     * @param nbGroups    the nb groups
     * @param nbOut       the nb out has to be a power of two
     */
    public Master(List<Competitor> competitors, int nbGroups, int nbOut) throws Exception {
        super(competitors);
        if (MathUtil.isAPowerOfTwo(nbOut)) {
            throw new NotAPowerOfTwoException("nbOut is not a power of 2");
        }
        this.nbOut = nbOut;
        this.groupStage = new GroupStage(new ArrayList<>(competitors), nbGroups);
    }

    public GroupStage getGroupStage() {
        return groupStage;
    }

    public ArrayList<Competitor> getFinalists() {
        return finalists;
    }

    public Competitor getWinner() {
        return winner;
    }

    public void setFinalists() {
        this.finalists = groupStage.initFinalists(this.nbOut);
    }

    /**
     * Play tournament.
     */
    public void playTournament() {
        Tournament tournament = new Tournament(finalists);
        tournament.play();
        winner = tournament.getCompetitorsRemaining().get(0);
    }

    @Override
    public void play() {
        groupStage.play();
        setFinalists();
        playTournament();
    }
}
