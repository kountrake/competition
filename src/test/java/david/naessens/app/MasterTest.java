package david.naessens.app;

import david.naessens.app.competitorsselector.BettersOut;
import david.naessens.app.competitorsselector.CompetitorsSelector;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MasterTest {

    private ArrayList<Competitor> competitors;
    private Master master;

    @BeforeEach
    void setup() throws Exception {
        competitors = CompetitorsGenerator.generateCompetitors(24);
        GroupStage groupStage = new GroupStage(competitors, 3);
        CompetitorsSelector competitorsSelector = new BettersOut(8);
        master = new Master(groupStage, competitorsSelector);
    }

    @Test
    void playTournamentTest() {
        master.getGroupStage().play();
        master.setFinalists();
        master.playTournament();
        assertNotNull(master.getWinner());
    }

    @Test
    void play3Groups8outTest() {
        master.play();
        assertNotNull(master.getWinner());
    }

    @Test
    void play4Groups8outTest() throws Exception {
        GroupStage groupStage = new GroupStage(competitors, 4);
        CompetitorsSelector competitorsSelector = new BettersOut(8);
        Master master2 = new Master(groupStage, competitorsSelector);
        master2.play();
        assertNotNull(master2.getWinner());
    }

    @Test
    void play4Groups16outTest() throws Exception {
        GroupStage groupStage1 = new GroupStage(competitors, 4);
        CompetitorsSelector competitorsSelector = new BettersOut(16);
        Master master2 = new Master(groupStage1, competitorsSelector);
        master2.play();
        assertNotNull(master2.getWinner());
    }

    @Test
    void masterSummaryToStringTest() {
        master.play();
        System.out.println(master.masterSummary());
        assertTrue(true);
    }
}
