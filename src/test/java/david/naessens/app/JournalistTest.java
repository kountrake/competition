package david.naessens.app;

import david.naessens.app.competition.League;
import david.naessens.app.competition.component.Competitor;
import david.naessens.app.sportObserver.Journalist;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JournalistTest {

    @Test
    void notifyMatchResultTest() {
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(4);
        League league = new League(competitors);
        league.addSportObserver(new Journalist("Fox News"));
        league.playMatch(competitors.get(0), competitors.get(1));
        assertTrue(true);
    }

}
