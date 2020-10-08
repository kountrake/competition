package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchTest {

    Competitor c1;
    Competitor c2;

    @BeforeEach
    void initialize(){
        c1 = new Competitor("Jhon");
        c2 = new Competitor("Doe",5);
    }

    @Test
    public void getCompetitorTest () {
        Match match = new Match(c1,c2);
        assertEquals(c1.getName(), match.getCompetitor1().getName());
        assertEquals(c2.getName(), match.getCompetitor2().getName());
    }


    @Test 
    public void playTest () {
        Match match = new Match(c1, c2);
        match.play();
        assertTrue((c1.getWins() == 1 && c2.getWins() == 0) || (c1.getWins() == 0 && c2.getWins() == 1));
    }
}