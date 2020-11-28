package david.naessens.app.competitorsselector;

import david.naessens.app.competition.component.Competitor;
import david.naessens.app.competition.component.GroupStage;

import java.util.ArrayList;

/**
 * The interface Competitors selector.
 */
public interface CompetitorsSelector {

    ArrayList<Competitor> initFinalists(GroupStage groupStage);

}
