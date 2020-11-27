package david.naessens.app;

import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookmakerTest {

    @Test
    void notifyMatchResultTest() {
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(4);
        Bookmaker bookmaker = new Bookmaker(competitors);
        bookmaker.notifyMatchResult(competitors.get(0), competitors.get(1));

        assertEquals(3.0, bookmaker.getOdds().get(competitors.get(1)));
        assertEquals(1.0, bookmaker.getOdds().get(competitors.get(0)));
    }
}
