package david.naessens.app;

import david.naessens.app.competitorsselector.BettersOut;
import david.naessens.app.exceptions.NotAPowerOfTwoException;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BettersOutTest {

    @Test
    void initFinalistsTest() throws NotAPowerOfTwoException {
        BettersOut bo = new BettersOut(8);
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(24);
        GroupStage groupStage = new GroupStage(competitors, 4);
        groupStage.play();
        ArrayList<Competitor> finalists = bo.initFinalists(groupStage);
        assertEquals(8, finalists.size());
        assertNotEquals(finalists.get(0), finalists.get(1));
        assertNotEquals(finalists.get(1), finalists.get(2));
        assertNotEquals(finalists.get(2), finalists.get(3));
        assertNotEquals(finalists.get(3), finalists.get(4));
        assertNotEquals(finalists.get(4), finalists.get(5));
        assertNotEquals(finalists.get(5), finalists.get(6));
        assertNotEquals(finalists.get(6), finalists.get(7));
    }
}
