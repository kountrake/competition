package app;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends Competition {

    private List<Competitor> competitors;
    ArrayList<Competitor> competitorsRemaining;

    public Tournament(List<Competitor> competitors) {
        super(competitors);
        competitorsRemaining = new ArrayList<>();
    }

    private void oddCompetitors(List<Competitor> c, ArrayList<Competitor> competitorsRemaining) {
        if (c.size() % 2 != 0) {
            competitorsRemaining.add(c.get(0));
            c.remove(0);
        }
    }

    private void playARound(List<Competitor> c, ArrayList<Competitor> competitorsRemaining) {
        for (int i = 1; i < c.size(); i += 2) {
            match.setCompetitor1(c.get(i - 1));
            match.setCompetitor1(c.get(i));
            match.play();
            if (match.getCompetitor1().getWins() == 1) {
                competitorsRemaining.add(c.get(i - 1));
                match.getCompetitor1().setWins(0);
            } else {
                competitorsRemaining.add(c.get(i));
                match.getCompetitor2().setWins(0);
            }
        }
    }

    public Competitor process(List<Competitor> c) {
        if (c.size() == 1) {
            return c.get(0);
        }
        oddCompetitors(c, competitorsRemaining);
        playARound(c, competitorsRemaining);
        return process(competitorsRemaining);
    }

    public void play() {
        process(competitors);
    }
}
