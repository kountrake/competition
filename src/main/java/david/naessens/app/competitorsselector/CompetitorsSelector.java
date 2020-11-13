package david.naessens.app.competitorsselector;

import david.naessens.app.Competitor;
import david.naessens.app.GroupStage;

import java.util.ArrayList;

/**
 * The interface Competitors selector.
 */
public interface CompetitorsSelector {

    ArrayList<Competitor> initFinalists(GroupStage groupStage);

}
