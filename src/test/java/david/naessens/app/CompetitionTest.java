package david.naessens.app;

import david.naessens.app.competition.Competition;
import david.naessens.app.competition.component.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static david.naessens.util.MathUtil.nbMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CompetitionTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;
    ArrayList<Competitor> competitors;
    MockCompetition competition;

    @BeforeEach
    void setUp() {
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
        c3 = new Competitor("Timo",2);
        c4 = new Competitor("Leon",7);
        competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competition = new MockCompetition(competitors);
    }

    @Test
    void playTest() {
        assertEquals(0, c1.getWins());
        assertEquals(0, c2.getWins());
        assertEquals(0, c3.getWins());
        assertEquals(0, c4.getWins());
        competition.play(competitors);
        int totalWins = competitors.get(0).getWins() + competitors.get(1).getWins() + competitors.get(2).getWins() + competitors.get(3).getWins();
        assertEquals(nbMatch(competitors.size()), totalWins, "Number of wins does not match the number of matches");
    }

    @Test
    void matchesAgainstOthersTest(){
        assertEquals(0, c1.getWins());
        assertEquals(0, c2.getWins());
        assertEquals(0, c3.getWins());
        assertEquals(0, c4.getWins());
        competition.matchesAgainstOthers(competitors,0);
        int totalWins = competitors.get(0).getWins() + competitors.get(1).getWins() + competitors.get(2).getWins() + competitors.get(3).getWins();
        assertEquals(3, totalWins, "Number of wins does not match the number of matches");
    }

    @Test
    void playMatchTest(){
        assertEquals(0, c1.getWins());
        assertEquals(0, c2.getWins());
        competition.playMatch(c1, c2);
        int totalWins = competitors.get(0).getWins() + competitors.get(1).getWins();
        assertEquals(1, totalWins, "Number of wins does not match the number of matches");
    }

    @Test
    void rankingTest() {
        Map<Competitor, Integer> ranks = competition.ranking();
        Set<Competitor> keys = ranks.keySet();
        int previous = 0;
        for (Competitor c: keys) {
            assertTrue(ranks.get(c) >= previous);
            previous = ranks.get(c);
        }
    }
}

class MockCompetition extends Competition {

    public MockCompetition(List<Competitor> competitors) {
        super(competitors);
    }
}