package david.naessens.app;

import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static david.naessens.util.MathUtil.nbMatch;
import static david.naessens.util.MathUtil.sumArray;
import static org.junit.jupiter.api.Assertions.*;

public class MasterTest {

    private ArrayList<Competitor> competitors;
    private Master master;

    @BeforeEach
    void setup() throws Exception {
        competitors = CompetitorsGenerator.generateCompetitors(24);
        master = new Master(competitors, 3, 8);
    }

    @Test
    void initGroupsTest() {
        master.initGroups();
        assertEquals(3, master.getGroups().size());
    }

    @Test
    void fillingGroupsTest() {
        master.initGroups();
        master.fillGroups();
        assertEquals(8, master.getGroups().get(0).getCompetitors().size());
        assertEquals(8, master.getGroups().get(1).getCompetitors().size());
        assertEquals(8, master.getGroups().get(2).getCompetitors().size());
    }

    @Test
    void initLeagueTest() {
        master.initGroups();
        master.fillGroups();
        master.initLeagues();
        assertEquals(3, master.getLeagues().size());
    }

    @Test
    void PlayGroupsTest() {
        master.initMasterGroupsStage();
        master.playGroups();
        HashMap<Competitor, Integer> ranks;
        for (League league : master.getLeagues()) {
            ranks = league.getRanks();
            int wins = sumArray(ranks.values());
            assertEquals(((nbMatch(league.getCompetitors().size()) * 2)), wins);
        }
        assertTrue(true);
    }

    @Test
    void initFinalistsTest() {
        master.initMasterGroupsStage();
        master.playGroups();
        master.initFinalists();
        assertEquals(8, master.getFinalists().size());
    }

    @Test
    void playTournamentTest() {
        master.initMasterGroupsStage();
        master.playGroups();
        master.initFinalists();
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
