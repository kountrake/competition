package david.naessens.app;

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
        master = new Master(competitors, 3, 8);
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
        Master master2 = new Master(competitors, 4, 8);
        master2.play();
        assertNotNull(master2.getWinner());
    }

    @Test
    void play4Groups16outTest() throws Exception {
        Master master2 = new Master(competitors, 4, 8);
        master2.play();
        assertNotNull(master2.getWinner());
    }
}
