package app;

import java.util.HashMap;
import java.util.List;

public class League extends Competition {

    public HashMap<Competitor, Integer> ranks;

    public League(List<Competitor> competitors) {
        super(competitors);
        ranks = new HashMap<>();
        for (Competitor c : competitors) {
            ranks.put(c, c.getWins());
        }

    }

    public List<Competitor> getCompetitors() {
        return super.competitors;
    }

    public HashMap<Competitor, Integer> getRanks() {
        return ranks;
    }

    public void play() {
        super.play(); //Matchs aller
        super.play(); //Matchs retour
        for (Competitor c :
                getCompetitors()) {
            ranks.replace(c, c.getWins());
        }
    }
}
