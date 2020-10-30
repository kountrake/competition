package david.naessens.app.masters.options;

import david.naessens.app.Competitor;

import java.util.ArrayList;

public abstract class MasterOption {
    private ArrayList<ArrayList<Competitor>> groups;
    public ArrayList<ArrayList<Competitor>> getGroups() {
        return groups;
    }
}
