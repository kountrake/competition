package david.naessens.app;

import david.naessens.app.competitorsselector.BettersOut;
import david.naessens.app.exceptions.NotAPowerOfTwoException;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BettersOutTest {

    @Test
    void initFinalistsTest() throws NotAPowerOfTwoException {
        BettersOut bo = new BettersOut(8);
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(24);
        GroupStage groupStage = new GroupStage(competitors, 4);
        groupStage.play();
        assertEquals(8, bo.initFinalists(groupStage).size());
    }
}
