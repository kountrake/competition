package david.naessens.app;

import david.naessens.app.masters.options.MasterOption;

import java.util.ArrayList;
import java.util.List;

public class Master extends Competition {

    MasterOption option;

    /**
     * Instantiates a new Competition.
     *
     * @param competitors the competitors
     */
    public Master(List<Competitor> competitors, MasterOption option) {
        super(competitors);
        this.option = option;
    }

    public void playGroups(){
        for (ArrayList<Competitor> group: option.getGroups()) {
            League league = new League(group);
            league.play();
        }
    }

}
