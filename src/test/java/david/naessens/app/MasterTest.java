package david.naessens.app;

import david.naessens.app.competition.Master;
import david.naessens.app.competition.component.Competitor;
import david.naessens.app.competitorsselector.BettersOut;
import david.naessens.app.competitorsselector.CompetitorsSelector;
import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MasterTest {

    private ArrayList<Competitor> competitors;
    private Master master;

    @BeforeEach
    void setup() throws Exception {
        competitors = CompetitorsGenerator.generateCompetitors(24);
        CompetitorsSelector competitorsSelector = new BettersOut(8);
        master = new Master(competitors, 3, competitorsSelector);
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
        CompetitorsSelector competitorsSelector = new BettersOut(8);
        Master master2 = new Master(competitors, 4, competitorsSelector);
        master2.play();
        assertNotNull(master2.getWinner());
    }

    @Test
    void play4Groups16outTest() throws Exception {
        CompetitorsSelector competitorsSelector = new BettersOut(16);
        Master master2 = new Master(competitors, 4, competitorsSelector);
        master2.play();
        assertNotNull(master2.getWinner());
    }
}
