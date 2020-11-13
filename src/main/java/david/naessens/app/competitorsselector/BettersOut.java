package david.naessens.app.competitorsselector;

import david.naessens.app.Competitor;
import david.naessens.app.GroupStage;
import david.naessens.app.exceptions.NotAPowerOfTwoException;
import david.naessens.util.MathUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The type Betters out.
 */
public class BettersOut implements CompetitorsSelector {

    private final int nbOut;

    /**
     * Instantiates a new Betters out.
     *
     * @param nbOut the number of competitors that goes to the final tournament
     * @throws NotAPowerOfTwoException thrown if the number of competitors is not a power of two
     */
    public BettersOut(int nbOut) throws NotAPowerOfTwoException {
        if ((MathUtil.isAPowerOfTwo(nbOut))) {
            throw new NotAPowerOfTwoException("Cannot take that number (" + nbOut + ") as a number of competitors to go out of groups");
        }
        this.nbOut = nbOut;
    }

    /**
     * Init finalists.
     *
     * @param groupStage the groupStage we need to get all the finalists that goes to the final tournament
     * @return All the competitors that goes the final tournament
     */
    public ArrayList<Competitor> initFinalists(GroupStage groupStage) {
        ArrayList<Competitor> finalists = new ArrayList<>();
        int cpt = 1;
        int position = 1;
        int i = 0;
        ArrayList<Competitor> comps = groupStage.getCompetitorsInPosition(0);
        while (cpt <= nbOut) {
            if (i >= comps.size()) {
                comps = groupStage.getCompetitorsInPosition(position);
                position++;
                i = 0;
            }
            finalists.add(comps.get(i));
            i++;
            cpt++;
        }
        Collections.shuffle(finalists);
        return finalists;
    }

}
