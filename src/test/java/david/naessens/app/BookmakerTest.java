package david.naessens.app;

import david.naessens.app.competition.component.Competitor;
import david.naessens.app.sportObserver.Bookmaker;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmakerTest {

    private Bookmaker bookmaker;
    private ArrayList<Competitor> competitors;

    @BeforeEach
    void setup() {
        competitors = CompetitorsGenerator.generateCompetitors(4);
        bookmaker = new Bookmaker(competitors);
    }

    @Test
    void notifyMatchResultTest() {

        bookmaker.notifyMatchResult(competitors.get(0), competitors.get(1));

        assertEquals(3.0, bookmaker.getOdds().get(competitors.get(1)));
        assertEquals(1.0, bookmaker.getOdds().get(competitors.get(0)));
    }

    @Test
    void oddDoesNotGetBellow1() {
        bookmaker.notifyMatchResult(competitors.get(0), competitors.get(1));
        bookmaker.notifyMatchResult(competitors.get(0), competitors.get(1));
        assertEquals(1., bookmaker.getOdds().get(competitors.get(0)));
    }
}
