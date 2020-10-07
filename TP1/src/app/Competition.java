package app;

import java.util.ArrayList;
import java.util.List;

public class Competition {

    private List<Competitor> competitors;
    private List<Integer> wins;

    public Competition(List<Competitor> competitors) {
        this.competitors = competitors;
        wins = new ArrayList<Integer>();
        for (Competitor c : competitors) {
            wins.add(0);
        }
    }

    public List<Integer> getWins() {
        return wins;
    }

    public int mostWin() {
        int most = 0;
        for (int i = 1; i < wins.size(); i++) {
            if (wins.get(most) < wins.get(i)) {
                most = i;
            }
        }
        return most;
    }

    public Competitor play() {
        for (int i = 0; i < competitors.size() - 1; i++) {
            for (int j = i + 1; j < competitors.size(); j++) {
                Match match = new Match(competitors.get(i), competitors.get(j));
                if (match.play() == 0) {
                    wins.set(i, wins.get(i) + 1);
                }
                wins.set(j, wins.get(j) + 1);
            }
        }
        return competitors.get(mostWin());
    }

}
