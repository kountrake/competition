package david.naessens.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    Competitor c1;
    Competitor c2;
    Match match;

    @BeforeEach
    void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
        match = new Match(c1,c2);
    }

    @Test
    void setWinnerTest(){
        assertNull(match.getWinner());
        match.setWinner(c1);
        assertEquals(c1, match.getWinner());
        match.setWinner(c2);
        assertEquals(c2, match.getWinner());
    }

    @Test
    void setCompetitor1Test(){
        assertEquals(c1, match.getCompetitor1());
        Competitor newOne = new Competitor("Tester");
        match.setCompetitor1(newOne);
        assertEquals(newOne, match.getCompetitor1());
    }

    @Test
    void setCompetitor2Test(){
        assertEquals(c2, match.getCompetitor2());
        Competitor newOne = new Competitor("Tester");
        match.setCompetitor2(newOne);
        assertEquals(newOne, match.getCompetitor2());
    }

    @Test 
    void playTest () {
        assertEquals(c1, match.getCompetitor1());
        assertEquals(match.getCompetitor1().getWins(), 0);
        assertEquals(c2, match.getCompetitor2());
        assertEquals(match.getCompetitor2().getWins(), 0);
        match.play();
        assertTrue(match.getWinner() == c1 || match.getWinner() == c2);
        assertTrue((c1.getWins() == 1 && c2.getWins() == 0) || (c1.getWins() == 0 && c2.getWins() == 1));
    }
}