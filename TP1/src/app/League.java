package app;

import java.util.HashMap;
import java.util.List;

public class League extends Competition {

    HashMap<Competitor, Integer> ranking;

    public League(List<Competitor> competitors) {
        super(competitors);
        for (Competitor c : competitors) {
            ranking.put(c, c.getWins());
        }

    }

    public void play() {
        super.play(); //Matchs aller
        super.play(); //Matchs retour
    }
}
