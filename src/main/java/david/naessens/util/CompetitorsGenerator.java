package david.naessens.util;

import david.naessens.app.competition.component.Competitor;

import java.util.ArrayList;

/**
 * An util class to generate some competitors.
 */
public class CompetitorsGenerator {

    /**
     * Generate competitors array list.
     *
     * @param amountOfCompetitor the amount of competitor to generate
     * @return An array list of the amount of competitors you chose to generate
     */
    public static ArrayList<Competitor> generateCompetitors(int amountOfCompetitor){
        ArrayList<Competitor> competitors = new ArrayList<>();
        for (int i = 0; i < amountOfCompetitor ; i++) {
            Competitor competitor = new Competitor("Competitor"+i, i%10);
            competitors.add(competitor);
        }
        return competitors;
    }
}
