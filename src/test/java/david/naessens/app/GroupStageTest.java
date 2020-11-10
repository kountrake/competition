package david.naessens.app;

import david.naessens.util.CompetitorsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static david.naessens.util.MathUtil.nbMatch;
import static david.naessens.util.MathUtil.sumArray;
import static org.junit.jupiter.api.Assertions.*;

public class GroupStageTest {

    private GroupStage groupStage;

    @BeforeEach
    void setup() {
        ArrayList<Competitor> competitors = CompetitorsGenerator.generateCompetitors(24);
        groupStage = new GroupStage(competitors, 3);
    }

    @Test
    void initGroupsTest() {
        groupStage.initGroups();
        assertEquals(3, groupStage.getGroups().size());
    }

    @Test
    void fillingGroupsTest() {
        groupStage.initGroups();
        groupStage.fillGroups();
        assertEquals(8, groupStage.getGroups().get(0).getCompetitors().size());
        assertEquals(8, groupStage.getGroups().get(1).getCompetitors().size());
        assertEquals(8, groupStage.getGroups().get(2).getCompetitors().size());
    }

    @Test
    void initLeagueTest() {
        groupStage.initGroups();
        groupStage.fillGroups();
        groupStage.initLeagues();
        assertEquals(3, groupStage.getLeagues().size());
    }

    @Test
    void PlayGroupsTest() {
        groupStage.initGroupsStage();
        groupStage.playGroups();
        HashMap<Competitor, Integer> ranks;
        for (League league : groupStage.getLeagues()) {
            ranks = league.getRanks();
            int wins = sumArray(ranks.values());
            assertNotEquals(0, wins);
            assertEquals(((nbMatch(league.getCompetitors().size()) * 2)), wins);
        }
        assertTrue(true);
    }

    @Test
    void ranksGroupStageToStringTest() {
        groupStage.play();
        System.out.print(groupStage.ranksGroupStageToString());
        assertTrue(true);
    }
}
