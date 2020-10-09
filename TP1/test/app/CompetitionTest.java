package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {

    Competitor c1;
    Competitor c2;
    Competitor c3;
    Competitor c4;
    MockCompetition competition;

    @BeforeEach
    void setUp() {
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
        c3 = new Competitor("Timo",2);
        c4 = new Competitor("Leon",7);
        ArrayList<Competitor> competitors = new ArrayList<>();
        competitors.add(c1);
        competitors.add(c2);
        competitors.add(c3);
        competitors.add(c4);
        competition = new MockCompetition(competitors);
    }

    @Test
    void playTest() {
    }

    @Test
    void testPlayTest() {
    }

    @Test
    void playMatchTest() {
        //competition.playMatch(c1, c2);
        System.out.format("%d %d",c1.getWins(), c2.getWins());
        assertTrue(c1.getWins() == 1 && c2.getWins() ==0 || c1.getWins() == 0 && c2.getWins() == 1);
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

class MockCompetition extends Competition{

    public MockCompetition(List<Competitor> competitors) {
        super(competitors);
    }
}