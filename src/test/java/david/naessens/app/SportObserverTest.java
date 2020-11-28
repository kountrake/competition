package david.naessens.app;

import david.naessens.app.competition.League;
import david.naessens.app.competition.component.Competitor;
import david.naessens.app.sportObserver.Bookmaker;
import david.naessens.app.sportObserver.Journalist;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportObserverTest {

    private League league;

    @BeforeEach
    void setup() {
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(4);
        Journalist journalist1 = new Journalist();
        Journalist journalist2 = new Journalist("CNews");
        Bookmaker bookmaker = new Bookmaker(competitors);
        league = new League(competitors);
        league.addSportObserver(journalist1);
        league.addSportObserver(bookmaker);
        league.addSportObserver(journalist2);
    }

    @Test
    void notifyMatchResultTest() {
        league.play();
        assertTrue(true);
    }

}
