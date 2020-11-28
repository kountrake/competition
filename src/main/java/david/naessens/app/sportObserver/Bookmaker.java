package david.naessens.app.sportObserver;

import david.naessens.app.competition.component.Competitor;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The type Bookmaker.
 */
public class Bookmaker implements SportObserver {

    private final HashMap<Competitor, Double> odds;

    /**
     * Instantiates a new Bookmaker.
     *
     * @param competitors the competitors
     */
    public Bookmaker(ArrayList<Competitor> competitors) {
        odds = new HashMap<>();
        for (Competitor competitor : competitors) {
            odds.put(competitor, (competitors.size()) / 2.0);
        }
    }

    /**
     * Gets odds.
     *
     * @return the odds
     */
    public HashMap<Competitor, Double> getOdds() {
        return odds;
    }

    @Override
    public void notifyMatchResult(Competitor winner, Competitor looser) {
        if (odds.get(winner) - 1 >= 1)
            odds.replace(winner, odds.get(winner) - 1);
        else
            odds.replace(winner, 1.);
        odds.replace(looser, odds.get(looser) + 1);
        System.out.println(
                "Update for the odds after the match opposing "
                        + winner.getName() + " versus " + looser.getName() + " : \n"
                        + "Competitor's name" + " | " + "previous odd" + " => " + "new odd" + "\n"
                        + "-------------------------------------------\n"
                        + winner.getName() + " | " + (odds.get(winner) + 1) + " => " + odds.get(winner) + "\n"
                        + looser.getName() + " | " + (odds.get(looser) - 1) + " => " + odds.get(looser) + "\n"
        );
    }
}
